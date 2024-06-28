package com.app.security.controller.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AuthLoginRequest(
        @NotNull(message = "enter a valid username") @NotBlank(message = "enter a valid username") @NotEmpty(message = "enter a valid username") String username,
        @NotNull(message = "enter a valid password") @NotBlank(message = "enter a valid password") @NotEmpty(message = "enter a valid password") String password) {
}
