package com.safebank.ledgerapi.account.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ledger_entries")
public class LedgerEntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TransactionType type;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal resultingBalance;

    @Column(length = 30)
    private String relatedAccountNumber;

    @Column(length = 240)
    private String description;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    protected LedgerEntryEntity() {
    }

    public LedgerEntryEntity(
            String accountNumber,
            TransactionType type,
            BigDecimal amount,
            BigDecimal resultingBalance,
            String relatedAccountNumber,
            String description
    ) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.resultingBalance = resultingBalance;
        this.relatedAccountNumber = relatedAccountNumber;
        this.description = description;
        this.createdAt = OffsetDateTime.now();
    }

    public Long getId() { return id; }
    public String getAccountNumber() { return accountNumber; }
    public TransactionType getType() { return type; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getResultingBalance() { return resultingBalance; }
    public String getRelatedAccountNumber() { return relatedAccountNumber; }
    public String getDescription() { return description; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
}
