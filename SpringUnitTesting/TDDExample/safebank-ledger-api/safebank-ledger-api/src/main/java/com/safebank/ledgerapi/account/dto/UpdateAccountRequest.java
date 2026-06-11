package com.safebank.ledgerapi.account.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateAccountRequest(
        @NotBlank String accountHolderName,
        @Email @NotBlank String email
) {
}
