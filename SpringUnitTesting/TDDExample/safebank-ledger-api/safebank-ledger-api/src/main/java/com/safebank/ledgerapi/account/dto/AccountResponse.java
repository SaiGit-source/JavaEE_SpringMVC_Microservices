package com.safebank.ledgerapi.account.dto;

import com.safebank.ledgerapi.account.entity.AccountStatus;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record AccountResponse(
        Long id,
        String accountNumber,
        String accountHolderName,
        String email,
        String currency,
        BigDecimal balance,
        AccountStatus status,
        OffsetDateTime createdAt
) {
}
