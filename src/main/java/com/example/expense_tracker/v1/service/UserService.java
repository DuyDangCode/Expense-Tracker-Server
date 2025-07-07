package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.dto.CreateUserDto;
import com.example.expense_tracker.v1.model.UserModel;
import com.example.expense_tracker.v1.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;


    public UserModel getUserById(long id) {
        Optional<UserModel> foundUser = userRepo.findById(id);
        if (foundUser.isEmpty()) {
            return null;
        }
        return foundUser.get();
    }

    public UserModel signUp(CreateUserDto userInfo) throws Exception {
        if (
                userInfo.getEmail().equals("1")
        )
            throw new Exception();
        UserModel newUser = UserModel.builder()
                .email(userInfo.getEmail())
                .name(userInfo.getEmail().split("@")[0])
                .password(userInfo.getPassword())
                .build();
        return newUser;
    }

    public String signIn() {
        return "ok";
    }
}
