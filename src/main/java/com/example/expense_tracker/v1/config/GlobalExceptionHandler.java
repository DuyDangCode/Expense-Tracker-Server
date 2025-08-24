package com.example.expense_tracker.v1.config;

import com.example.expense_tracker.v1.core.CategoryNotFoundException;
import com.example.expense_tracker.v1.core.ErrorResponse;
import com.example.expense_tracker.v1.core.ResourceNotFoundException;
import com.example.expense_tracker.v1.core.UserNotFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {
    @ExceptionHandler({UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundResource(Exception e, WebRequest request) {
        var newErrorResponse = ErrorResponse.builder()
                .error(e.toString())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .path(request.getDescription(false).replace("uri=", ""))
                .message(e.getMessage())
                .build();
        return newErrorResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    //todo: change message to "something went wrong"
    public ErrorResponse handleException(Exception e, WebRequest request) {
        var newErrorResponse = ErrorResponse.builder()
                .error(e.toString())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .path(request.getDescription(false).replace("uri=", ""))
                .message(e.getMessage())
                .build();
        return newErrorResponse;
    }


}
