package com.example.expense_tracker.v1.core;

public class ForbiddenError extends RuntimeException {
    public ForbiddenError() {
        super("Forbidden error");
    }
}
