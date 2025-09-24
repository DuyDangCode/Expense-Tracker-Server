package com.example.expense_tracker.v1.controller;

import com.example.expense_tracker.v1.core.ResponseSuccess;
import com.example.expense_tracker.v1.dto.CreateTransactionDto;
import com.example.expense_tracker.v1.dto.UpdateTransctionDto;
import com.example.expense_tracker.v1.model.UserModel;
import com.example.expense_tracker.v1.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseSuccess create(@RequestBody CreateTransactionDto newTransaction, @AuthenticationPrincipal UserModel userModel) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .status(2001)
                .message("Create transaction successful")
                .body(transactionService.create(newTransaction, userModel))
                .build());
    }

    @GetMapping
    public ResponseSuccess getAll(@AuthenticationPrincipal UserModel userDetail) {

        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .status(2001)
                .message("Get all transactions successful")
                .body(transactionService.getAllTransaction(userDetail.getId()))
                .build());
    }

    @GetMapping("/categories/{id}")
    public ResponseSuccess get(@Param("id") long categoryId, @AuthenticationPrincipal UserModel userModel) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .status(2001)
                .message("Get transaction successful")
                .body(transactionService.getTransactionsByCategory(userModel.getId(), categoryId))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseSuccess update(@PathVariable("id") long id, @RequestBody UpdateTransctionDto updateTransctionDto, @AuthenticationPrincipal UserModel userModel) {
        return new ResponseSuccess(HttpStatus.OK,
                ResponseSuccess.Payload.builder()
                        .message("Update transaction successful")
                        .status(2000)
                        .body(transactionService.update(id, userModel.getId(), updateTransctionDto))
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseSuccess delete(@PathVariable("id") long id, @AuthenticationPrincipal UserModel userModel) {
        return new ResponseSuccess(HttpStatus.OK, ResponseSuccess.Payload.builder()
                .message("Delete transaction successful")
                .body(transactionService.delete(id, userModel.getId()))
                .status(2000)
                .build());
    }


}
