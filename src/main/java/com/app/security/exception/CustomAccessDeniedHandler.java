package com.app.security.exception;

import com.app.layer.common.utils.constant.ErrorCatalog;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    ObjectMapper objectMapper = new ObjectMapper();
    JavaTimeModule javaTimeModule = new JavaTimeModule();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        objectMapper.registerModule(javaTimeModule);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Throwable cause = accessDeniedException.getCause();
        ErrorResponse errorResponse = new ErrorResponse();

        if (cause instanceof JWTVerificationException) {
            errorResponse.setCode(ErrorCatalog.GENERIC_ERROR.getCode());
            errorResponse.setMessage("Token expired");
            errorResponse.setDetails(Collections.singletonList(cause.getMessage()));
        } else {
            errorResponse.setCode(ErrorCatalog.GENERIC_ERROR.getCode());
            errorResponse.setMessage("Access denied, you dont have permission to access this resource");
            errorResponse.setDetails(Collections.singletonList(accessDeniedException.getMessage()));
        }

        errorResponse.setTime(LocalDateTime.now());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
