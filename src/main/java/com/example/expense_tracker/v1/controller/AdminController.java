package com.example.expense_tracker.v1.controller;

import com.example.expense_tracker.v1.core.ResponseSuccess;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @GetMapping("/users")
    public ResponseSuccess getAllUsers() {
        return new ResponseSuccess(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseSuccess deleteUser(@PathVariable("id") long id) {
        return new ResponseSuccess(HttpStatus.OK);
    }
}
