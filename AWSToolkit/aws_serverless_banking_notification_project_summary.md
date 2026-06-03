# AWS Serverless Banking Notification Processor

## Project Overview

This project is a Java-based AWS Lambda application that processes banking transaction JSON files uploaded to an Amazon S3 bucket. When a transaction file is uploaded, the Lambda function reads the file from S3, logs processing details to Amazon CloudWatch, and sends a notification through Amazon SNS.

The project demonstrates a simple serverless banking alert workflow using:

- Amazon S3 for storing transaction JSON files
- AWS Lambda for serverless processing
- Amazon SNS for alert notifications
- Amazon CloudWatch for logging and monitoring
- Java 17 and Maven for application development and packaging

---

## Main Use Case

The system is designed to process bank transaction records automatically.

When a JSON file is uploaded to the S3 bucket, the flow is:

```text
Upload transaction JSON to S3
→ S3 triggers AWS Lambda
→ Lambda reads the file from S3
→ Lambda logs the transaction processing steps to CloudWatch
→ Lambda sends an SNS notification
```

If the uploaded file name contains `REJECTED`, the Lambda treats it as a suspicious transaction and sends a security alert.

---

## AWS Resources Used

### 1. Amazon S3

Bucket used:

```text
secure-bank-records-saito-2026
```

This bucket stores transaction JSON files such as:

```text
transaction_001.json
transaction_002.json
transaction_REJECTED_001.json
transaction_REJECTED_002.json
```

The Lambda function reads these files using the `s3:GetObject` permission.

---

### 2. AWS Lambda

Lambda function:

```text
BankingNotificationProcessor
```

Runtime:

```text
Java 17
```

Handler:

```text
com.awstoolkit.TransactionHandler::handleRequest
```

The Lambda is responsible for:

- Receiving the S3 event
- Extracting the bucket name and object key
- Downloading the transaction JSON file from S3
- Checking whether the file name contains `REJECTED`
- Sending a normal notification or security alert using SNS
- Writing logs to CloudWatch

---

### 3. Amazon SNS

SNS topic:

```text
arn:aws:sns:us-east-1:577638386543:BankingAlerts
```

The Lambda publishes notification messages to this SNS topic.

Normal transaction message example:

```text
Bank Notification: File [transaction_001.json] was successfully compiled and stored.
```

Rejected transaction message example:

```text
SECURITY ALERT: A transaction file marked as REJECTED was processed.
```

---

### 4. Amazon CloudWatch

CloudWatch is used to check Lambda execution logs.

Log group:

```text
/aws/lambda/BankingNotificationProcessor
```

Example successful logs:

```text
[CLOUDWATCH INFO] Lambda execution triggered by S3 Event.
[CLOUDWATCH INFO] Attempting to process file: transaction_002.json from bucket: secure-bank-records-saito-2026
[CLOUDWATCH SUCCESS] Successfully downloaded file payload from S3
[CLOUDWATCH SUCCESS] SNS Alert successfully published
```

Example rejected transaction log:

```text
[CLOUDWATCH WARNING] Security flag! Rejected transaction record detected
```

---

## Java Project Structure

Expected Maven project structure:

```text
bank-processor
├── pom.xml
├── src
│   └── main
│       └── java
│           └── com
│               └── awstoolkit
│                   ├── S3BankService.java
│                   └── TransactionHandler.java
└── target
    └── bank-processor-1.0.0.jar
```

---

## Main Java Classes

### S3BankService.java

This class is responsible for connecting to S3 and reading the uploaded transaction file.

Main responsibility:

```text
Download transaction JSON file from S3 and convert it into a String.
```

Important method:

```java
public String getTransactionFileContent(String bucketName, String fileName)
```

This method:

- Builds a `GetObjectRequest`
- Downloads the object from S3
- Reads the file content as UTF-8 text
- Returns the JSON content as a raw string
- Logs critical errors if S3 access fails

---

### TransactionHandler.java

This is the AWS Lambda handler class.

It implements:

```java
RequestHandler<S3Event, String>
```

Main method:

```java
public String handleRequest(S3Event s3Event, Context context)
```

This method:

1. Receives the S3 event
2. Extracts the bucket name
3. Extracts the uploaded file name
4. Reads the JSON file from S3 using `S3BankService`
5. Logs the file content to CloudWatch
6. Checks whether the file name contains `REJECTED`
7. Sends an SNS notification

Business rule:

```java
if (fileName.contains("REJECTED")) {
    sendNotification("SECURITY ALERT: A transaction file marked as REJECTED was processed.");
    return "Flagged suspicious transaction processed.";
}
```

Important note: the current logic checks the **file name**, not the JSON field value.  
So a file named `transaction_002.json` with `"status": "REJECTED"` will still be treated as a normal file unless the file name contains `REJECTED`.

---

## Maven Build

The project uses Maven to build the Java Lambda package.

Build command used:

```powershell
mvn clean package "-Dmaven.test.skip=true"
```

The generated JAR file is:

```text
target/bank-processor-1.0.0.jar
```

This JAR was uploaded to AWS Lambda.

---

## Deployment Notes

During deployment, the Lambda originally failed with:

```text
Class not found: example.Hello
```

This happened because the Lambda handler was still pointing to the default handler.

The handler was corrected to:

```text
com.awstoolkit.TransactionHandler::handleRequest
```

Another issue occurred:

```text
Class not found: com.awstoolkit.TransactionHandler
```

This was caused by uploading the wrong ZIP structure. The fix was to upload the actual generated JAR file, because the JAR contained:

```text
com/awstoolkit/TransactionHandler.class
```

---

## Test Payloads

### Valid S3 Event Payload

Use this payload to manually test the Lambda:

```json
{
  "Records": [
    {
      "eventVersion": "2.1",
      "eventSource": "aws:s3",
      "awsRegion": "us-east-1",
      "eventTime": "2026-06-02T23:55:00.000Z",
      "eventName": "ObjectCreated:Put",
      "s3": {
        "bucket": {
          "name": "secure-bank-records-saito-2026",
          "arn": "arn:aws:s3:::secure-bank-records-saito-2026"
        },
        "object": {
          "key": "transaction_002.json",
          "size": 1024
        }
      }
    }
  ]
}
```

### Rejected Transaction S3 Event Payload

```json
{
  "Records": [
    {
      "eventVersion": "2.1",
      "eventSource": "aws:s3",
      "awsRegion": "us-east-1",
      "eventTime": "2026-06-02T23:55:00.000Z",
      "eventName": "ObjectCreated:Put",
      "s3": {
        "bucket": {
          "name": "secure-bank-records-saito-2026",
          "arn": "arn:aws:s3:::secure-bank-records-saito-2026"
        },
        "object": {
          "key": "transaction_REJECTED_002.json",
          "size": 1024
        }
      }
    }
  ]
}
```

---

## Sample Transaction JSON

### Normal Transaction

```json
{
  "transactionId": "TXN001",
  "customerId": "CUST1001",
  "accountNumber": "1234567890",
  "amount": 250.75,
  "currency": "CAD",
  "transactionType": "DEBIT",
  "merchant": "Amazon Canada",
  "status": "APPROVED",
  "timestamp": "2026-06-02T23:55:00Z"
}
```

### Rejected Transaction

```json
{
  "transactionId": "TXN999",
  "customerId": "CUST9001",
  "accountNumber": "9876543210",
  "amount": 9500.00,
  "currency": "CAD",
  "transactionType": "WIRE_TRANSFER",
  "merchant": "Unknown Offshore Account",
  "status": "REJECTED",
  "riskScore": 98,
  "reason": "Suspicious high-value transfer to unknown destination",
  "timestamp": "2026-06-02T23:58:00Z"
}
```

---

## IAM Permissions Required

The Lambda execution role used was:

```text
BankingNotificationProcessor-role-23pu1wca
```

The role needs these permissions:

```text
s3:GetObject
s3:ListBucket
sns:Publish
logs:CreateLogGroup
logs:CreateLogStream
logs:PutLogEvents
```

Example inline policy:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "AllowReadTransactionFilesFromS3",
      "Effect": "Allow",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::secure-bank-records-saito-2026/*"
    },
    {
      "Sid": "AllowListTransactionBucket",
      "Effect": "Allow",
      "Action": "s3:ListBucket",
      "Resource": "arn:aws:s3:::secure-bank-records-saito-2026"
    },
    {
      "Sid": "AllowPublishBankingAlerts",
      "Effect": "Allow",
      "Action": "sns:Publish",
      "Resource": "arn:aws:sns:us-east-1:577638386543:BankingAlerts"
    }
  ]
}
```

---

## Errors Encountered and Fixes

### 1. Maven Not Found

Problem:

```text
mvn command not recognized or Maven not found
```

Fix:

- Installed Apache Maven manually
- Added Maven `bin` folder to Windows PATH
- Verified Maven using:

```powershell
mvn -version
```

---

### 2. Maven Test Compile Error

Problem:

```text
cannot find symbol: method assertTrue(boolean)
```

Cause:

```text
JUnit test file AppTest.java was missing proper dependency/import.
```

Temporary fix:

```powershell
mvn clean package "-Dmaven.test.skip=true"
```

---

### 3. Missing POM Error

Problem:

```text
The goal you specified requires a project to execute but there is no POM in this directory
```

Cause:

```text
Maven was run from the parent folder instead of the bank-processor folder.
```

Fix:

```powershell
cd AWSToolkitank-processor
mvn clean package "-Dmaven.test.skip=true"
```

---

### 4. Class Not Found: example.Hello

Cause:

```text
Lambda was still configured with the default handler.
```

Fix:

```text
Handler changed to com.awstoolkit.TransactionHandler::handleRequest
```

---

### 5. Class Not Found: com.awstoolkit.TransactionHandler

Cause:

```text
Wrong deployment package structure was uploaded.
```

Fix:

```text
Uploaded the actual Maven-generated JAR file.
```

Verified JAR content using:

```powershell
jar tf targetank-processor-1.0.0.jar | findstr TransactionHandler
```

Expected output:

```text
com/awstoolkit/TransactionHandler.class
```

---

### 6. Index 0 Out of Bounds

Problem:

```text
Index 0 out of bounds for length 0
```

Cause:

```text
Lambda test event had no S3 Records.
```

Fix:

```text
Used a proper S3 event payload with Records[0].
```

Recommended code improvement:

```java
if (s3Event == null || s3Event.getRecords() == null || s3Event.getRecords().isEmpty()) {
    logger.log("[CLOUDWATCH WARNING] No S3 records found in event payload.");
    return "No S3 records found. Use a valid S3 event payload.";
}
```

---

### 7. S3 Access Denied

Problem:

```text
not authorized to perform: s3:GetObject
```

Fix:

```text
Added s3:GetObject permission to the Lambda execution role.
```

---

### 8. SNS Access Denied

Problem:

```text
not authorized to perform: SNS:Publish
```

Fix:

```text
Added sns:Publish permission to the Lambda execution role.
```

---

### 9. S3 NoSuchKey

Problem:

```text
The specified key does not exist
```

Cause:

```text
The file name in the Lambda test payload did not exactly match the S3 object key.
```

Fix:

```text
Used the exact object key from the S3 bucket.
```

---

## Automatic Invocation

To invoke Lambda automatically, an S3 trigger must be added:

```text
Lambda → BankingNotificationProcessor → Configuration → Triggers → Add trigger
```

Trigger settings:

```text
Source: S3
Bucket: secure-bank-records-saito-2026
Event type: All object create events
```

After this setup, uploading or re-uploading a JSON file to S3 automatically invokes Lambda.

Recommended test filenames:

```text
transaction_003.json
transaction_004.json
transaction_REJECTED_003.json
transaction_REJECTED_004.json
```

---

## Current Status

The project is now able to:

- Build using Maven
- Deploy to AWS Lambda
- Use the correct Java handler
- Read transaction files from S3
- Log execution steps to CloudWatch
- Publish SNS notifications
- Detect suspicious transactions based on `REJECTED` in the file name

The core serverless banking notification workflow is functional.
