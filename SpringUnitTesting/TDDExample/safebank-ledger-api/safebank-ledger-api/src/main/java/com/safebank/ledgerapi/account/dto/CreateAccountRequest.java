package com.safebank.ledgerapi.account.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreateAccountRequest(
        @NotBlank String accountNumber,
        @NotBlank String accountHolderName,
        @Email @NotBlank String email,
        @NotBlank @Size(min = 3, max = 3) String currency,
        @NotNull @PositiveOrZero BigDecimal openingBalance
) {
}
