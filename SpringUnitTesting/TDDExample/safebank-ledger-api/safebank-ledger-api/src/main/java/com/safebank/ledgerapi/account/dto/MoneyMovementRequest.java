package com.safebank.ledgerapi.account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record MoneyMovementRequest(
        @NotNull @Positive BigDecimal amount,
        String description
) {
}
