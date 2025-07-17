package com.example.expense_tracker.v1.config;

import com.example.expense_tracker.v1.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus()
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
