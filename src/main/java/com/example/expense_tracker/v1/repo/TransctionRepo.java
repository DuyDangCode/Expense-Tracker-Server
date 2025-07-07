package com.example.expense_tracker.v1.repo;

import com.example.expense_tracker.v1.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransctionRepo extends JpaRepository<TransactionModel, Long> {
}
