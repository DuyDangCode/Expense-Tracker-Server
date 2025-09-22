package com.example.expense_tracker.v1.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public record UpdateCategoryDto(
        @NotNull
        String name
) {
}