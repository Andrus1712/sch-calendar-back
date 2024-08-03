package com.app.core.infrastructure.advice;

import com.app.core.common.exception.ClientNotFoundException;
import com.app.security.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static com.app.core.common.utils.constant.ErrorCatalog.CLIENT_NOT_FOUND;

@RestControllerAdvice
public class ClientAdvice {
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handInvalidCredentialException(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(CLIENT_NOT_FOUND.getCode());
        error.setMessage(CLIENT_NOT_FOUND.getMessage());
        error.setTime(LocalDateTime.now());
        return error;
    }
}
