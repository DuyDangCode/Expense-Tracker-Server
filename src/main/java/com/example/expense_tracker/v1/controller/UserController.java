package com.example.expense_tracker.v1.controller;

import com.example.expense_tracker.v1.dto.CreateUserDto;
import com.example.expense_tracker.v1.core.ResponseSuccess;
import com.example.expense_tracker.v1.dto.SignInUserDto;
import com.example.expense_tracker.v1.service.UserService;
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

    @GetMapping("/{id}")
    public ResponseSuccess getInfo(@PathVariable("id") @Validated() long id) {
        return new ResponseSuccess(HttpStatus.OK,
                ResponseSuccess.Payload.builder().status(HttpStatus.OK.value()).body(
                        userService.getUserById(id)
                ).build());

    }

    @PostMapping("/sign-up")
    public ResponseSuccess signUp(@RequestBody CreateUserDto user) throws Exception {
        return new ResponseSuccess(HttpStatus.OK,
                ResponseSuccess.Payload.builder().status(HttpStatus.OK.value()).message("Sign up successful").body(
                        userService.signUp(user)
                ).build());

    }

    @PostMapping("/sign-in")
    public ResponseSuccess signIn(@RequestBody SignInUserDto user) throws Exception {
        return new ResponseSuccess(HttpStatus.OK,
                ResponseSuccess.Payload.builder().status(HttpStatus.OK.value()).message("Sign in successful").body(
                        userService.signIn(user)
                ).build());

    }

    @PostMapping("/refresh-token/{token}")
    public ResponseSuccess refreshToken(@PathVariable String token) {
        return new ResponseSuccess(HttpStatus.OK,
                ResponseSuccess.Payload.builder().status(HttpStatus.OK.value()).message("Refresh token").body(userService.refreshToken(token)).build()
        );
    }

}
