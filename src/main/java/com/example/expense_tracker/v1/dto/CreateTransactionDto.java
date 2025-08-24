package com.example.expense_tracker.v1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateTransactionDto {
    @NotNull
    private Long categoryId;
    @NotNull
    private TransctionType type;
    @PositiveOrZero
    private long amount;

    private Date date = new Date();
    private String note = "";
    @Null
    private Long userId;
}
