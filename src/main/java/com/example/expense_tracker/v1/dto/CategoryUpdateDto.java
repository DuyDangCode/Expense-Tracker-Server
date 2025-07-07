package com.example.expense_tracker.v1.dto;


import jakarta.validation.constraints.NotNull;

public class CategoryUpdateDto {
    @NotNull
    private String name;
}
