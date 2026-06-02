package com.awstoolkit;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

public class TransactionHandler implements RequestHandler<S3Event, String> {

    // Instantiate your modular S3 connection service
    private final S3BankService s3BankService = new S3BankService();

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        LambdaLogger logger = context.getLogger();
        
        logger.log("[CLOUDWATCH INFO] Lambda execution triggered by S3 Event.");

        try {
            // 1. Extract the bucket name and file name from the S3 event metadata
            String bucketName = s3Event.getRecords().get(0).getS3().getBucket().getName();
            String fileName = s3Event.getRecords().get(0).getS3().getObject().getKey();
            
            logger.log("[CLOUDWATCH INFO] Attempting to process file: " + fileName + " from bucket: " + bucketName);

            // 2. Call your separate S3 service file to download the actual JSON content string
            String rawJsonContent = s3BankService.getTransactionFileContent(bucketName, fileName);
            logger.log("[CLOUDWATCH SUCCESS] Successfully downloaded file payload from S3:\n" + rawJsonContent);

            // 3. Conditional business logic rules
            if (fileName.contains("REJECTED")) {
                logger.log("[CLOUDWATCH WARNING] Security flag! Rejected transaction record detected: " + fileName);
                sendNotification("SECURITY ALERT: A transaction file marked as REJECTED was processed.");
                return "Flagged suspicious transaction processed.";
            }

            // 4. Trigger the standard asynchronous notification
            String alertMessage = String.format("Bank Notification: File [%s] was successfully compiled and stored.", fileName);
            sendNotification(alertMessage);
            
            logger.log("[CLOUDWATCH SUCCESS] SNS Alert successfully published for: " + fileName);
            
        } catch (Exception e) {
            // 5. Catch any system failures and log the complete crash trace cleanly to CloudWatch
            logger.log("[CLOUDWATCH CRITICAL] Processing failed! Stack Error trace: " + e.getMessage());
            throw e; 
        }

        return "Transaction Processed Successfully";
    }

    /**
     * Publishes a string message down your AWS SNS asynchronous messaging fabric.
     */
    private void sendNotification(String message) {
        // Build the SNS connection client using environmental configurations
        try (SnsClient snsClient = SnsClient.builder().build()) {
            
            // NOTE: Replace this ARN placeholder with your real SNS topic ARN from AWS Toolkit
            String topicArn = "arn:aws:sns:us-east-1:123456789012:BankingAlerts"; 

            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .topicArn(topicArn)
                    .build();

            snsClient.publish(request);
        }
    }
}
