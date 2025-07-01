package com.example.expense_tracker.v1.controller;

import com.example.expense_tracker.v1.dto.ResponseFailure;
import com.example.expense_tracker.v1.dto.ResponseSuccess;
import com.example.expense_tracker.v1.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/:id")
    public ResponseSuccess getInfo(@Param("id") @Validated() long id){
       try {
           return new ResponseSuccess(HttpStatus.OK,
                   ResponseSuccess.Payload.builder().status(200).body(
                           userService.findUserById(id)
                   ).build());
       }catch (Exception e) {
           return new ResponseFailure(HttpStatus.BAD_REQUEST,
                   ResponseSuccess.Payload.builder().status(400).message("Bad request").build());
       }
    }



}
