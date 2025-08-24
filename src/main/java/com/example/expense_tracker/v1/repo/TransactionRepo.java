package com.example.expense_tracker.v1.repo;

import com.example.expense_tracker.v1.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionModel, Long> {
    Optional<List<TransactionModel>> findAllByUserIdAndCategoryId(long userId, long categoryId);

    Optional<List<TransactionModel>> findAllByUserId(long userId);
}
