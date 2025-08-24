package com.example.expense_tracker.v1.core;

public class TransactionNotFoundException extends ResourceNotFoundException {
    public TransactionNotFoundException() {
        super("Not found transaction");
    }
}
