package com.example.expense_tracker.v1.dto;

import com.example.expense_tracker.v1.model.CategoryModel;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public record UpdateTransctionDto(

        @PositiveOrZero(message = "amount cant be nagitive")
        Long amount,

        TransctionType type,

        Date date,

        CategoryModel category,

        String note
) {
    public UpdateTransctionDto {
        if (date == null) {
            date = new Date();
        }
    }
}
