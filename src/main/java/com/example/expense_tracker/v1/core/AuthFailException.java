package com.example.expense_tracker.v1.core;


public class AuthFailException extends RuntimeException {
    public AuthFailException() {
        super("Cant authentication");
    }
}

