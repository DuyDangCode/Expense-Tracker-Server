package com.example.expense_tracker.v1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public record CreateCategoryDto (
        @NotBlank(message = "Category name is required")
     String name,
     long userId
){}

