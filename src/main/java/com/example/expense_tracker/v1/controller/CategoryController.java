package com.example.expense_tracker.v1.controller;

import com.example.expense_tracker.v1.dto.CreateCategoryDto;
import com.example.expense_tracker.v1.dto.ResponseSuccess;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @PostMapping()
    public ResponseSuccess create() {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder().build());
    }

    @GetMapping()
    public ResponseSuccess getAll() {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder().build());
    }

    @GetMapping("/:id")
    public ResponseSuccess get(long id) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder().build());
    }

    @PutMapping("/:id")
    public ResponseSuccess update(@Param("id") long id, CreateCategoryDto categoryInput) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder().build());
    }

    @DeleteMapping("/:id")
    public ResponseSuccess delete(@Param("id") long id) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder().build());
    }
}
