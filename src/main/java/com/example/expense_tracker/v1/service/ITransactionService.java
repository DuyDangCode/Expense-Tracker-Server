package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.dto.CreateTransactionDto;
import com.example.expense_tracker.v1.dto.UpdateTransctionDto;
import com.example.expense_tracker.v1.model.TransactionModel;
import com.example.expense_tracker.v1.model.UserModel;

import java.util.List;

public interface ITransactionService {
    TransactionModel create(CreateTransactionDto newTransaction, UserModel user);

    List<TransactionModel> getTransactionsByCategory(long userId, long categoryId);

    List<TransactionModel> getAllTransaction(long userId);

    boolean update(long transactionId, long userId, UpdateTransctionDto newTransactionInfo);


    boolean delete(long transactionId, long userId);
}
