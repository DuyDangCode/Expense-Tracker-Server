package com.example.expense_tracker.v1.dto;


import lombok.Getter;
import lombok.Setter;

public record SignInUserDto(
        String email,
        String password
) {
}
