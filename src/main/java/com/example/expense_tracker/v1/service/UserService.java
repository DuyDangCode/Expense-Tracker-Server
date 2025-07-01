package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.model.UserModel;
import com.example.expense_tracker.v1.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public UserModel findUserById(long id) throws Exception {
        Optional<UserModel> user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new Exception();
        }
        return user.get();
    }
}
