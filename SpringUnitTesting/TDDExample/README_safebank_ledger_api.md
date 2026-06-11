# SafeBank Ledger API

## Project Summary

**SafeBank Ledger API** is an original Spring Boot banking REST API built for learning **Test-Driven Development (TDD)** style backend development with a clean layered architecture.

The project simulates a small banking ledger system where users can create bank accounts, deposit money, withdraw money, transfer money between accounts, view account balances, and inspect ledger entries for every financial movement.

This project uses **MariaDB** as the database. It does **not** require Docker or PostgreSQL.

The goal of this project is to demonstrate how a real backend application can be organized using:

```text
Controller layer → Service layer → Repository layer → MariaDB database
```

The project is intentionally simple enough to understand, but realistic enough to show common enterprise backend patterns such as validation, exception handling, transactions, repositories, DTOs, and tests.

---

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 22 | Main programming language |
| Spring Boot 3.4.5 | Application framework |
| Spring Web | REST API endpoints |
| Spring Data JPA | Database access layer |
| Hibernate | JPA implementation |
| MariaDB | Relational database |
| Jakarta Validation | Request validation |
| JUnit 5 | Unit and integration testing |
| Mockito | Mocking dependencies in service tests |
| MockMvc | Testing controller endpoints |
| Maven | Build and dependency management |

---

## High-Level Architecture

```text
Client / Postman / Browser / React
        ↓
AccountController
        ↓
AccountService
        ↓
AccountRepository + LedgerEntryRepository
        ↓
MariaDB
```

### Layer Responsibilities

#### 1. Controller Layer

The controller receives HTTP requests and sends HTTP responses.

Main class:

```text
AccountController
```

Responsibilities:

```text
- Accept REST API requests
- Validate request bodies
- Extract path variables and query parameters
- Call AccountService
- Return JSON responses
```

#### 2. Service Layer

The service contains the core banking business logic.

Main class:

```text
AccountService
```

Responsibilities:

```text
- Create accounts
- Update account holder details
- Deposit money
- Withdraw money
- Transfer money
- Check account status
- Check sufficient funds
- Record ledger entries
- Close accounts
```

#### 3. Repository Layer

Repositories handle database operations.

Main classes:

```text
AccountRepository
LedgerEntryRepository
```

Responsibilities:

```text
- Save account records
- Find accounts by account number
- Search accounts by account holder name
- Save ledger entries
- Retrieve ledger history
```

#### 4. Database Layer

MariaDB stores account and ledger data.

Main tables:

```text
bank_accounts
ledger_entries
```

---

## Project Structure

```text
safebank-ledger-api/
│
├── bin/
│   ├── schema.sql
│   ├── data.sql
│   └── README.md
│
├── pom.xml
├── README.md
│
└── src/
    ├── main/
    │   ├── java/com/safebank/ledgerapi/
    │   │   ├── LedgerApiApplication.java
    │   │   │
    │   │   ├── common/
    │   │   │   └── error/
    │   │   │       ├── ApiErrorResponse.java
    │   │   │       ├── BadRequestException.java
    │   │   │       ├── ConflictException.java
    │   │   │       ├── NotFoundException.java
    │   │   │       └── GlobalExceptionHandler.java
    │   │   │
    │   │   └── account/
    │   │       ├── entity/
    │   │       │   ├── AccountEntity.java
    │   │       │   ├── LedgerEntryEntity.java
    │   │       │   ├── AccountStatus.java
    │   │       │   └── TransactionType.java
    │   │       │
    │   │       ├── dto/
    │   │       │   ├── CreateAccountRequest.java
    │   │       │   ├── UpdateAccountRequest.java
    │   │       │   ├── MoneyMovementRequest.java
    │   │       │   ├── TransferRequest.java
    │   │       │   ├── AccountResponse.java
    │   │       │   └── LedgerEntryResponse.java
    │   │       │
    │   │       ├── repository/
    │   │       │   ├── AccountRepository.java
    │   │       │   └── LedgerEntryRepository.java
    │   │       │
    │   │       ├── service/
    │   │       │   └── AccountService.java
    │   │       │
    │   │       └── web/
    │   │           └── AccountController.java
    │   │
    │   └── resources/
    │       └── application.properties
    │
    └── test/
        └── java/com/safebank/ledgerapi/account/
            ├── service/
            │   └── AccountServiceTest.java
            └── web/
                └── AccountControllerTest.java
```

---

## Main Business Features

### 1. Create a Bank Account

Creates a new bank account with an account number, account holder name, email, currency, and opening balance.

If the opening balance is greater than zero, the system automatically creates an opening `DEPOSIT` ledger entry.

### 2. List Bank Accounts

Returns all bank accounts.

Optional search by account holder name is supported.

### 3. Get Account by Account Number

Finds one account using its account number.

If the account does not exist, the API returns a `404 Not Found` response.

### 4. Update Account Holder Details

Updates the account holder name and email address.

Only active accounts can be updated.

### 5. Deposit Money

Adds money to an active account and records a `DEPOSIT` ledger entry.

### 6. Withdraw Money

Subtracts money from an active account and records a `WITHDRAWAL` ledger entry.

The service checks that the account has enough funds before allowing the withdrawal.

### 7. Transfer Money

Moves money from one active account to another active account.

The service checks:

```text
- Source and destination accounts are different
- Both accounts exist
- Both accounts are active
- Both accounts use the same currency
- Source account has enough funds
```

A successful transfer creates two ledger entries:

```text
TRANSFER_OUT for the sender
TRANSFER_IN for the receiver
```

### 8. View Ledger Entries

Returns all ledger entries for a selected account.

Ledger entries are ordered by newest first.

### 9. Close Account

Marks an account as closed.

The account can only be closed when its balance is exactly zero.

---

## REST API Endpoints

Base path:

```text
/api/accounts
```

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/accounts` | List all accounts |
| GET | `/api/accounts?name=sai` | Search accounts by holder name |
| GET | `/api/accounts/{accountNumber}` | Get one account |
| POST | `/api/accounts` | Create a new account |
| PUT | `/api/accounts/{accountNumber}` | Update account holder details |
| POST | `/api/accounts/{accountNumber}/deposit` | Deposit money |
| POST | `/api/accounts/{accountNumber}/withdraw` | Withdraw money |
| POST | `/api/accounts/transfer` | Transfer money between accounts |
| GET | `/api/accounts/{accountNumber}/ledger` | View account ledger |
| DELETE | `/api/accounts/{accountNumber}` | Close an account |

---

## Database Design

### Table 1: `bank_accounts`

Stores account-level information.

| Column | Type | Purpose |
|---|---|---|
| `id` | BIGINT | Primary key |
| `account_number` | VARCHAR(30) | Unique business account number |
| `account_holder_name` | VARCHAR(120) | Customer/account holder name |
| `email` | VARCHAR(160) | Account holder email |
| `currency` | VARCHAR(3) | Currency code, such as CAD |
| `balance` | DECIMAL(19,2) | Current account balance |
| `status` | VARCHAR(20) | ACTIVE or CLOSED |
| `created_at` | DATETIME(6) | Account creation timestamp |

### Table 2: `ledger_entries`

Stores all account movements.

| Column | Type | Purpose |
|---|---|---|
| `id` | BIGINT | Primary key |
| `account_number` | VARCHAR(30) | Account affected by the entry |
| `type` | VARCHAR(20) | DEPOSIT, WITHDRAWAL, TRANSFER_IN, TRANSFER_OUT |
| `amount` | DECIMAL(19,2) | Money movement amount |
| `resulting_balance` | DECIMAL(19,2) | Balance after the transaction |
| `related_account_number` | VARCHAR(30) | Other account involved in transfer |
| `description` | VARCHAR(240) | Optional note |
| `created_at` | DATETIME(6) | Transaction timestamp |

---

## Entity Summary

### AccountEntity

Represents a row in the `bank_accounts` table.

Important fields:

```text
id
accountNumber
accountHolderName
email
currency
balance
status
createdAt
```

### LedgerEntryEntity

Represents a row in the `ledger_entries` table.

Important fields:

```text
id
accountNumber
type
amount
resultingBalance
relatedAccountNumber
description
createdAt
```

---

## Enums

### AccountStatus

Possible values:

```text
ACTIVE
CLOSED
```

### TransactionType

Possible values:

```text
DEPOSIT
WITHDRAWAL
TRANSFER_IN
TRANSFER_OUT
```

---

## DTO Summary

DTOs are used so the API does not expose entities directly.

### CreateAccountRequest

Used when creating a new account.

Expected fields:

```text
accountNumber
accountHolderName
email
currency
openingBalance
```

### UpdateAccountRequest

Used when updating account holder information.

Expected fields:

```text
accountHolderName
email
```

### MoneyMovementRequest

Used for deposits and withdrawals.

Expected fields:

```text
amount
description
```

### TransferRequest

Used for transferring money between accounts.

Expected fields:

```text
fromAccountNumber
toAccountNumber
amount
description
```

### AccountResponse

Returned to the client when account data is requested.

### LedgerEntryResponse

Returned to the client when ledger entries are requested.

---

## Application Configuration

Main configuration file:

```text
src/main/resources/application.properties
```

Current settings:

```properties
spring.application.name=safebank-ledger-api
server.port=8086

spring.datasource.url=jdbc:mariadb://localhost:3306/safebank_ledger
spring.datasource.username=root
spring.datasource.password=maria
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
```

The API runs on:

```text
http://localhost:8086
```

---

## SQL Files

The project includes MariaDB-compatible SQL files in the `bin` folder.

```text
bin/schema.sql
bin/data.sql
```

### `schema.sql`

Creates the database and tables.

It does the following:

```text
- Drops safebank_ledger if it already exists
- Creates safebank_ledger
- Creates bank_accounts table
- Creates ledger_entries table
```

### `data.sql`

Adds sample banking data.

It inserts:

```text
- Sample bank accounts
- Sample deposit entries
- Sample withdrawal entries
- Sample transfer entries
```

---

## How to Run the SQL Files Manually

### Step 1: Go to the `bin` folder

Example:

```cmd
cd C:\Users\saito\source\repos\Telusko_Java_Enterprise_Spring\JavaEE_SpringMVC_Microservices\SpringUnitTesting\TDDExample\safebank-ledger-api\safebank-ledger-api\bin
```

### Step 2: Run `schema.sql`

Use the full path to your MariaDB client.

Example:

```cmd
"C:\Program Files\MariaDB 11.3\bin\mysql.exe" -u root -p < schema.sql
```

If your MariaDB folder is different, find it with:

```cmd
where /R "C:\Program Files" mysql.exe
```

or:

```cmd
where /R "C:\Program Files" mariadb.exe
```

Then use the path that Windows returns.

### Step 3: Run `data.sql`

```cmd
"C:\Program Files\MariaDB 11.3\bin\mysql.exe" -u root -p < data.sql
```

If you have `mariadb.exe` instead of `mysql.exe`, use:

```cmd
"C:\Program Files\MariaDB 11.3\bin\mariadb.exe" -u root -p < schema.sql
"C:\Program Files\MariaDB 11.3\bin\mariadb.exe" -u root -p < data.sql
```

---

## How to Run the Spring Boot Application

From the project root folder:

```cmd
mvn clean package
```

Then:

```cmd
mvn spring-boot:run
```

Or run the packaged JAR:

```cmd
java -jar target\ledger-api-0.0.1-SNAPSHOT.jar
```

The API should start on:

```text
http://localhost:8086
```

---

## Example API Requests

### 1. List All Accounts

```cmd
curl http://localhost:8086/api/accounts
```

### 2. Search Accounts by Name

```cmd
curl "http://localhost:8086/api/accounts?name=maya"
```

### 3. Get One Account

```cmd
curl http://localhost:8086/api/accounts/SB-100001
```

### 4. Create Account

```cmd
curl -X POST http://localhost:8086/api/accounts ^
  -H "Content-Type: application/json" ^
  -d "{\"accountNumber\":\"SB-200001\",\"accountHolderName\":\"James Miller\",\"email\":\"james.miller@example.com\",\"currency\":\"CAD\",\"openingBalance\":1000.00}"
```

### 5. Deposit Money

```cmd
curl -X POST http://localhost:8086/api/accounts/SB-100001/deposit ^
  -H "Content-Type: application/json" ^
  -d "{\"amount\":250.00,\"description\":\"Payroll deposit\"}"
```

### 6. Withdraw Money

```cmd
curl -X POST http://localhost:8086/api/accounts/SB-100001/withdraw ^
  -H "Content-Type: application/json" ^
  -d "{\"amount\":100.00,\"description\":\"ATM withdrawal\"}"
```

### 7. Transfer Money

```cmd
curl -X POST http://localhost:8086/api/accounts/transfer ^
  -H "Content-Type: application/json" ^
  -d "{\"fromAccountNumber\":\"SB-100001\",\"toAccountNumber\":\"SB-100003\",\"amount\":75.00,\"description\":\"Dinner split\"}"
```

### 8. View Ledger Entries

```cmd
curl http://localhost:8086/api/accounts/SB-100001/ledger
```

### 9. Close Account

Only works if the account balance is zero.

```cmd
curl -X DELETE http://localhost:8086/api/accounts/SB-100005
```

---

## Business Rules

The service enforces several important banking rules.

### Duplicate Account Number Not Allowed

If an account number already exists, creating another account with the same number returns a conflict error.

### Only Active Accounts Can Be Modified

Closed accounts cannot receive deposits, withdrawals, transfers, or updates.

### Withdrawal Requires Sufficient Funds

A withdrawal is rejected if the account balance is lower than the requested amount.

### Transfer Requires Matching Currency

Transfers are only allowed between accounts with the same currency.

### Transfer Cannot Use Same Account

The source and destination account cannot be the same.

### Account Must Have Zero Balance Before Closing

An account cannot be closed unless its balance is zero.

---

## Error Handling

The project uses a global exception handler.

Main error classes:

```text
BadRequestException
ConflictException
NotFoundException
GlobalExceptionHandler
ApiErrorResponse
```

Typical HTTP responses:

| Error | HTTP Status | Example Cause |
|---|---|---|
| BadRequestException | 400 | Withdraw amount is invalid, balance is insufficient, transfer to same account |
| ConflictException | 409 | Duplicate account number |
| NotFoundException | 404 | Account number does not exist |
| Validation error | 400 | Required field missing or invalid |

---

## Testing Strategy

The project includes tests for the service and controller layers.

### Service Tests

Main test file:

```text
AccountServiceTest.java
```

Purpose:

```text
- Test business logic without starting the full web server
- Mock repositories using Mockito
- Verify deposit, withdrawal, transfer, and error behavior
```

### Controller Tests

Main test file:

```text
AccountControllerTest.java
```

Purpose:

```text
- Test REST endpoints
- Use MockMvc
- Verify HTTP status codes
- Verify JSON responses
```

### Run Tests

```cmd
mvn test
```

If tests fail because MariaDB is not running or not configured, run:

```cmd
mvn clean package -DskipTests
```

---

## TDD-Style Development Flow

This project is suitable for TDD-style practice.

A typical TDD workflow would be:

```text
1. Write a failing test
2. Implement the minimum code to pass the test
3. Refactor the code
4. Add the next test
5. Repeat
```

Example sequence:

```text
1. Test create account
2. Implement create account
3. Test duplicate account number
4. Implement duplicate check
5. Test deposit
6. Implement deposit logic
7. Test withdrawal with insufficient funds
8. Implement validation
9. Test transfer
10. Implement transfer logic
```

---

## How the Transfer Flow Works

```text
Client sends transfer request
        ↓
AccountController.transfer()
        ↓
AccountService.transfer()
        ↓
Validate source and target accounts
        ↓
Check both accounts are active
        ↓
Check same currency
        ↓
Check source has sufficient funds
        ↓
Subtract amount from source account
        ↓
Add amount to destination account
        ↓
Save both accounts
        ↓
Create TRANSFER_OUT ledger entry for source
        ↓
Create TRANSFER_IN ledger entry for destination
        ↓
Return updated account responses
```

---

## Why Ledger Entries Are Important

The account balance shows the current amount of money in the account.

The ledger shows how the account reached that balance.

Example:

```text
Opening deposit: +3000.00
Payroll deposit: +500.00
ATM withdrawal: -249.25
Transfer out: -100.00
Current balance: 3150.75
```

This is closer to how real banking systems work because a bank should not only know the balance, but also maintain a record of every money movement.

---

## Sample Data Included

The `data.sql` file includes sample accounts such as:

```text
SB-100001 - Aarav Patel
SB-100002 - Maya Chen
SB-100003 - Noah Williams
SB-100004 - Emma Singh
SB-100005 - Liam Brown
```

It also includes example ledger entries for deposits, withdrawals, and transfers.

---

## Notes for MariaDB on Windows

If this command fails:

```cmd
mysql -u root -p
```

it means MariaDB is installed, but the command-line client is not available in your PATH.

Use the full path instead:

```cmd
"C:\Program Files\MariaDB 11.3\bin\mysql.exe" -u root -p
```

If that path does not exist, search for the real path:

```cmd
where /R "C:\Program Files" mysql.exe
where /R "C:\Program Files" mariadb.exe
```

---

## Summary

SafeBank Ledger API is a clean Spring Boot banking backend project using MariaDB. It demonstrates a practical REST API with layered architecture, validation, error handling, JPA repositories, transaction-safe service logic, ledger tracking, and tests.

The project is useful for learning:

```text
- Spring Boot REST APIs
- Controller-service-repository architecture
- MariaDB integration
- JPA entities and repositories
- DTO-based API design
- Exception handling
- Banking transaction logic
- TDD-style backend development
```
