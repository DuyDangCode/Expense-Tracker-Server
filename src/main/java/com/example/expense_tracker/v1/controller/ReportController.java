package com.example.expense_tracker.v1.controller;


import com.example.expense_tracker.v1.core.ResponseSuccess;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    @GetMapping("/summary")
    public ResponseSuccess getSummary() {
        return new ResponseSuccess(HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseSuccess getByCategory() {
        return new ResponseSuccess(HttpStatus.OK);
    }

    @GetMapping("/export-csv")
    public ResponseSuccess exportCsv() {
        return new ResponseSuccess(HttpStatus.OK);
    }
}
