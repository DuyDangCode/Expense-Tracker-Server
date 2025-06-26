package com.example.expense_tracker.v1.dto;

import org.springframework.http.HttpStatus;

public class ResponseFailure  extends  ResponseSuccess{
    public ResponseFailure(HttpStatus status, String message) {
        super(status, message);
    }
}
