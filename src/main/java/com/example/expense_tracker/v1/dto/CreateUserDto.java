package com.example.expense_tracker.v1.dto;


import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    private String email;
    private String password;
}
