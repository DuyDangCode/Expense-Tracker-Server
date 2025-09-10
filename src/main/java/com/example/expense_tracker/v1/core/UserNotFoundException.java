package com.example.expense_tracker.v1.core;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException() {
        super("Not found user");
    }
}
