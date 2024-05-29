package com.app.layer.infrastructure.advice;

import com.app.layer.common.exception.ScheduleNotFoundException;
import com.app.security.exception.ErrorResponse;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.CredentialException;
import java.time.LocalDateTime;
import java.util.Collections;

import static com.app.layer.common.utils.constant.ErrorCatalog.*;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CredentialException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handInvalidCredentialException(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(INVALID_CREDENTIALS.getCode());
        error.setMessage(INVALID_CREDENTIALS.getMessage());
        error.setDetails(Collections.singletonList(e.getMessage()));
        error.setTime(LocalDateTime.now());
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ScheduleNotFoundException.class)
    public ErrorResponse handScheduleNotFoundException() {
        ErrorResponse error = new ErrorResponse();
        error.setCode(SCH_NOT_FOUND.getCode());
        error.setMessage(SCH_NOT_FOUND.getMessage());
        error.setTime(LocalDateTime.now());
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleInvalidGenericError(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(GENERIC_ERROR.getCode());
        error.setMessage(GENERIC_ERROR.getMessage());
        error.setDetails(Collections.singletonList(e.getMessage()));
        error.setTime(LocalDateTime.now());
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnsupportedOperationException.class)
    public ErrorResponse UnsupportedOperationException(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(GENERIC_ERROR.getCode());
        error.setMessage(e.getMessage());
        error.setDetails(Collections.singletonList(e.getMessage()));
        error.setTime(LocalDateTime.now());
        return error;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JWTVerificationException.class)
    public ErrorResponse handJWTVerificationException(JWTVerificationException e) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(INVALID_TOKEN.getCode());
        error.setMessage(INVALID_TOKEN.getMessage());
        error.setDetails(Collections.singletonList(e.getMessage()));
        error.setTime(LocalDateTime.now());
        return error;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AccessDeniedException.class)
    public ErrorResponse handAccessDeniedException(AccessDeniedException e) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(INVALID_TOKEN.getCode());
        error.setMessage(INVALID_TOKEN.getMessage());
        error.setDetails(Collections.singletonList(e.getMessage()));
        error.setTime(LocalDateTime.now());
        return error;
    }
}
