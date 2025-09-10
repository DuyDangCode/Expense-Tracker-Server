package com.example.expense_tracker.v1.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateTransctionDto {

    @PositiveOrZero(message = "amount cant be nagitive")
    private Long amount;

    private TransctionType type;

    private Date date;

    private Long categoryId;

    private String note;
}
