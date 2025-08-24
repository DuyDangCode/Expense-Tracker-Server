package com.example.expense_tracker.v1.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;


public class ResponseSuccess extends ResponseEntity {

    public ResponseSuccess(HttpStatusCode status) {
        super(status);
    }

    public ResponseSuccess(HttpStatusCode status, Payload body) {
        super(body, status);
    }

    @AllArgsConstructor
    @RequiredArgsConstructor
    @Builder
    @Getter
    public static class Payload {
        private final int status;
        private final String message;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Object body;
    }
}
