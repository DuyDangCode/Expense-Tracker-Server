package com.example.expense_tracker.v1.core;

public class UserAlreadyExistsException extends AlreadyExistsException {
    public UserAlreadyExistsException() {
        super("User is exist");
    }
}
