# SafeBank Ledger API

SafeBank Ledger API is an original Spring Boot REST project for learning TDD-style backend development with a banking domain.

It is inspired by the common Controller-Service-Repository learning pattern, but it is not a copy of the uploaded copyrighted project. The domain, entity model, endpoint design, naming, behavior, and tests are original.

## What this project does

The API manages simple bank accounts and ledger entries.

It supports:

- Create bank accounts
- List accounts
- Search accounts by account holder name
- Get one account by account number
- Update account holder details
- Deposit money
- Withdraw money
- Transfer money between accounts
- View account ledger entries
- Close an account when balance is zero

## Technology stack

- Java 22
- Spring Boot 3.4.5
- Spring Web
- Spring Data JPA
- Spring Validation
- MariaDB
- JUnit 5
- Mockito
- MockMvc

No Docker is required.
No PostgreSQL is required.

## Architecture

```text
Client / Postman / React
        ↓
AccountController
        ↓
AccountService
        ↓
AccountRepository + LedgerEntryRepository
        ↓
MariaDB
```

## Database setup

Create the MariaDB database first:

```sql
CREATE DATABASE safebank_ledger;
```

Default configuration:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/safebank_ledger
spring.datasource.username=root
spring.datasource.password=maria
```

Update `src/main/resources/application.properties` if your MariaDB password is different.

## Run the project

```bash
mvn clean test
mvn spring-boot:run
```

The API runs on:

```text
http://localhost:8086
```

## Endpoints

### Create account

```http
POST /api/accounts
```

```json
{
  "accountNumber": "ACC-1001",
  "accountHolderName": "Sai",
  "email": "sai@example.com",
  "currency": "CAD",
  "openingBalance": 100.00
}
```

### List accounts

```http
GET /api/accounts
```

### Search accounts by name

```http
GET /api/accounts?name=sai
```

### Get account

```http
GET /api/accounts/ACC-1001
```

### Update account

```http
PUT /api/accounts/ACC-1001
```

```json
{
  "accountHolderName": "Sai G",
  "email": "sai.g@example.com"
}
```

### Deposit

```http
POST /api/accounts/ACC-1001/deposit
```

```json
{
  "amount": 250.00,
  "description": "Paycheque"
}
```

### Withdraw

```http
POST /api/accounts/ACC-1001/withdraw
```

```json
{
  "amount": 50.00,
  "description": "ATM withdrawal"
}
```

### Transfer

```http
POST /api/accounts/transfer
```

```json
{
  "fromAccountNumber": "ACC-1001",
  "toAccountNumber": "ACC-2001",
  "amount": 75.00,
  "description": "Rent split"
}
```

### View ledger

```http
GET /api/accounts/ACC-1001/ledger
```

### Close account

```http
DELETE /api/accounts/ACC-1001
```

The account can only be closed if its balance is zero.

## TDD-style learning flow

A good way to learn from this project:

1. Start with `AccountServiceTest`.
2. Test duplicate account number behavior.
3. Test deposit behavior.
4. Test insufficient funds behavior.
5. Implement service logic.
6. Test `AccountController` with MockMvc.
7. Run the app and test endpoints with Postman.

## Business rules

- Account numbers must be unique.
- Deposits must be positive.
- Withdrawals must be positive.
- Withdrawals cannot exceed current balance.
- Transfers cannot be sent to the same account.
- Transfers require both accounts to use the same currency.
- Closed accounts cannot be used for transactions.
- Accounts can only be closed when balance is zero.
