package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.pidev.Entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t " +
        "FROM Transaction t " +
        "JOIN t.sourceBankAccount s " +
        "JOIN t.destinedBankAccount d " +
        "WHERE s.id = :id OR d.id = :id " +
        "ORDER BY t.date DESC"
    )
    List<Transaction> findTransactionsByBankAccountId(@Param("id") Long id);
}
