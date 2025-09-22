package com.example.expense_tracker.v1.dto;

public record TokensPairDto(
        String accessToken,
        String refreshToken
) {
}
