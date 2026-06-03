package com.example.disaster.controller;

import com.example.disaster.model.User;
import com.example.disaster.service.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authService.login(
                user.getEmail(),
                user.getPassword()
        );
    }
}