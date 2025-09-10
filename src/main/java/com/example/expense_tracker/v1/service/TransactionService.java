package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.core.ForbiddenError;
import com.example.expense_tracker.v1.core.TransactionNotFoundException;
import com.example.expense_tracker.v1.dto.CreateTransactionDto;
import com.example.expense_tracker.v1.model.TransactionModel;
import com.example.expense_tracker.v1.dto.UpdateTransctionDto;
import com.example.expense_tracker.v1.repo.TransactionRepo;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {
    private final TransactionRepo transactionRepo;

    @Override
    public TransactionModel create(CreateTransactionDto newTransactionInfo) {
        TransactionModel newTransaction = new TransactionModel(newTransactionInfo);
        transactionRepo.save(newTransaction);
        return newTransaction;
    }

    @Override
    public List<TransactionModel> getTransactionsByCategory(long userId, long categoryId) {
        return transactionRepo.findAllByUserIdAndCategoryId(userId, categoryId).orElse(null);
    }

    @Override
    public List<TransactionModel> getAllTransaction(long userId) {
        return transactionRepo.findAllByUserId(userId).orElse(null);
    }

    @Override
    public boolean update(long transactionId, long userId, UpdateTransctionDto newTransactionInfo) {
        TransactionModel foundTransaction = findTransaction(transactionId, userId);
        foundTransaction.update(newTransactionInfo);
        return true;
    }

    @Override
    public boolean delete(long transactionId, long userId) {
        TransactionModel transaction = findTransaction(transactionId, userId);
        transaction.delete();
        return true;
    }

    public TransactionModel findTransaction(long transactionId, long userId) {
        Optional<TransactionModel> foundTransaction = transactionRepo.findById(transactionId);
        if (foundTransaction.isEmpty())
            throw new TransactionNotFoundException();
        TransactionModel transaction = foundTransaction.get();
        if (transaction.getUserId() != userId) throw new ForbiddenError();
        return transaction;
    }
}
