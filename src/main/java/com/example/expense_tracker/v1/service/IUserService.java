package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.dto.CreateUserDto;
import com.example.expense_tracker.v1.dto.SignInUserDto;
import com.example.expense_tracker.v1.model.UserModel;

public interface IUserService {
    UserModel signUp(CreateUserDto userInfo) throws Exception;

    String signIn(SignInUserDto userInfo) throws Exception;

    String refreshToken(String token) throws Exception;
}
