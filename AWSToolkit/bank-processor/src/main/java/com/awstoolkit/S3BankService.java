package com.awstoolkit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class S3BankService {

    // The client automatically manages connections and reuses environment credentials
    private final S3Client s3Client;

    public S3BankService() {
        this.s3Client = S3Client.builder().build();
    }

    /**
     * Downloads a transaction JSON file from S3 and converts it to a raw String.
     */
    public String getTransactionFileContent(String bucketName, String fileName) {
        try {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .build();

            // Fetch the stream from S3 and read it line-by-line into a single String
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(s3Client.getObject(getObjectRequest), StandardCharsets.UTF_8))) {
                
                return reader.lines().collect(Collectors.joining("\n"));
            }

        } catch (S3Exception e) {
            System.err.println("[CLOUDWATCH CRITICAL] S3 API Call failed for file: " + fileName);
            throw e;
        } catch (Exception e) {
            System.err.println("[CLOUDWATCH CRITICAL] General I/O Error reading S3 file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
