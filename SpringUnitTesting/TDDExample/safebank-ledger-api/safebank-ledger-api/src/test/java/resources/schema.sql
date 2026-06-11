DROP DATABASE IF EXISTS safebank_ledger;
CREATE DATABASE safebank_ledger;
USE safebank_ledger;

DROP TABLE IF EXISTS ledger_entries;
DROP TABLE IF EXISTS bank_accounts;

CREATE TABLE bank_accounts (
    id BIGINT NOT NULL AUTO_INCREMENT,
    account_number VARCHAR(30) NOT NULL,
    account_holder_name VARCHAR(120) NOT NULL,
    email VARCHAR(160) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    balance DECIMAL(19,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_bank_accounts_account_number (account_number)
);

CREATE TABLE ledger_entries (
    id BIGINT NOT NULL AUTO_INCREMENT,
    account_number VARCHAR(30) NOT NULL,
    type VARCHAR(20) NOT NULL,
    amount DECIMAL(19,2) NOT NULL,
    resulting_balance DECIMAL(19,2) NOT NULL,
    related_account_number VARCHAR(30),
    description VARCHAR(240),
    created_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id),
    KEY idx_ledger_entries_account_number (account_number)
);
