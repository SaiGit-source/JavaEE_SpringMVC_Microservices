package com.safebank.ledgerapi.account.repository;

import com.safebank.ledgerapi.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
    boolean existsByAccountNumber(String accountNumber);
    List<AccountEntity> findByAccountHolderNameContainingIgnoreCase(String name);
}
