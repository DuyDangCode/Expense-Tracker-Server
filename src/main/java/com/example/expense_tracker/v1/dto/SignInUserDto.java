package com.example.expense_tracker.v1.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInUserDto {
    private String email;
    private String password;
}
