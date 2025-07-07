package com.example.expense_tracker.v1.config;

import com.example.expense_tracker.v1.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e, WebRequest request) {
        var newErrorResponse = ErrorResponse.builder()
                .error(e.toString())
                .status(500)
                .timestamp(new Date())
                .path(request.getDescription(false).replace("uri=", ""))
                .message(e.getMessage())
                .build();
        return newErrorResponse;
    }
}
