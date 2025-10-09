package com.example.expense_tracker.v1.core;

public class CategoryFoundException extends RuntimeException {
    public CategoryFoundException() {
        super("Category is exist!");
    }
}