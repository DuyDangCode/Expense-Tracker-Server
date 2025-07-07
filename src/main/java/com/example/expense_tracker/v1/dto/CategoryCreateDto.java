package com.example.expense_tracker.v1.dto;

import lombok.Getter;

@Getter
public class CategoryCreateDto {
    private String name;
    private long userId;
}
