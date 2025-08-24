package com.example.expense_tracker.v1.controller;

import com.example.expense_tracker.v1.dto.CreateCategoryDto;
import com.example.expense_tracker.v1.core.ResponseSuccess;
import com.example.expense_tracker.v1.dto.UpdateCategoryDto;
import com.example.expense_tracker.v1.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping()
    public ResponseSuccess create(@RequestBody CreateCategoryDto createCategoryDto) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .message("Create category successful")
                .status(2001)
                .body(categoryService.create(createCategoryDto))
                .build());
    }

    @GetMapping("/{userId}")
    public ResponseSuccess getAll(@PathVariable("userId") long userId) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .message("Get all categories successful")
                .status(2000)
                .body(categoryService.getAll(userId))
                .build());
    }

    @GetMapping("/{categoryId}")
    public ResponseSuccess get(@PathVariable("categoryId") long id) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .message("Get category successful")
                .status(2000)
                .body(categoryService.getInfoById(id))
                .build());
    }

    @PutMapping("/{categoryId}")
    public ResponseSuccess update(@PathVariable("categoryId") long id, UpdateCategoryDto categoryInput) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .message("Update category successful")
                .status(2000)
                .body(categoryService.update(categoryInput, id))
                .build());
    }

    @DeleteMapping("/{categoryId}")
    public ResponseSuccess delete(@PathVariable("categoryId") long id) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .message("Delete category successful")
                .status(2000)
                .body(categoryService.delete(id))
                .build());
    }
}
