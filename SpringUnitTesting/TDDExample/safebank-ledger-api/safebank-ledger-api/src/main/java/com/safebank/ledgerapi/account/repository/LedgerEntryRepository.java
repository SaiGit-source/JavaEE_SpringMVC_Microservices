package com.safebank.ledgerapi.account.repository;

import com.safebank.ledgerapi.account.entity.LedgerEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntryEntity, Long> {
    List<LedgerEntryEntity> findByAccountNumberOrderByCreatedAtDesc(String accountNumber);
}
