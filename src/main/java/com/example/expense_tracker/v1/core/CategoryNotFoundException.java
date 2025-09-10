package com.example.expense_tracker.v1.core;

public class CategoryNotFoundException extends ResourceNotFoundException {
    public CategoryNotFoundException() {
        super("Not found category");
    }
}
