package com.example.expense_tracker.v1.dto;


import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

public record CreateUserDto(
        String email,
        String password
) {
}
