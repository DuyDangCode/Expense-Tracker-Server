package com.example.expense_tracker.v1.dto;

import com.example.expense_tracker.v1.model.CategoryModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public record CreateTransactionDto(
        @NotNull
        CategoryModel category,
        @NotNull
        TransctionType type,
        @PositiveOrZero
        long amount,
        Date date,
        String note,
        @Null
        Long userId
) {
    public CreateTransactionDto {
        if (date == null) {
            date = new Date();
        }
    }
}
