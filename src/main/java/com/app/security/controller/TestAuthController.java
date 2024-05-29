package com.app.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/test")
public class TestAuthController {

    @GetMapping
    public String hello() {
        return "hello world";
    }

    @GetMapping("/se")
    public String helloSecurity() {
        return "hello world secured";
    }
}
