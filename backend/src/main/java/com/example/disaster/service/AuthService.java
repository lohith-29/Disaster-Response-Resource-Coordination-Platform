package com.example.disaster.service;

import com.example.disaster.model.User;
import com.example.disaster.repository.UserRepository;
import com.example.disaster.security.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // REGISTER
    public User register(User user) {

        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    // LOGIN
    public String login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                password,
                user.getPassword()
        )) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(
                user.getEmail(),
                user.getRole()
        );
    }
}