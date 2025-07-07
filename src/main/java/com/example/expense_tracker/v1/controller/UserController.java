package com.example.expense_tracker.v1.controller;

import com.example.expense_tracker.v1.dto.CreateUserDto;
import com.example.expense_tracker.v1.dto.ResponseFailure;
import com.example.expense_tracker.v1.dto.ResponseSuccess;
import com.example.expense_tracker.v1.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/:id")
    public ResponseSuccess getInfo(@Param("id") @Validated() long id) {
        try {
            return new ResponseSuccess(HttpStatus.OK,
                    ResponseSuccess.Payload.builder().status(200).body(
                            userService.getUserById(id)
                    ).build());
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST,
                    ResponseSuccess.Payload.builder().status(400).message("Bad request").build());
        }
    }

    @PostMapping("/sign-up")
    public ResponseSuccess signUp(@RequestBody CreateUserDto user) {
        try {
            return new ResponseSuccess(HttpStatus.OK,
                    ResponseSuccess.Payload.builder().status(200).message("Sign up successful").body(
                            userService.signUp(user)
                    ).build());
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST,
                    ResponseSuccess.Payload.builder().status(400).message("Bad request").build());
        }
    }

}
