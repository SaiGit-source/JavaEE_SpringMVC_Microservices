package com.safebank.ledgerapi.account.dto;

import com.safebank.ledgerapi.account.entity.TransactionType;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record LedgerEntryResponse(
        Long id,
        String accountNumber,
        TransactionType type,
        BigDecimal amount,
        BigDecimal resultingBalance,
        String relatedAccountNumber,
        String description,
        OffsetDateTime createdAt
) {
}
