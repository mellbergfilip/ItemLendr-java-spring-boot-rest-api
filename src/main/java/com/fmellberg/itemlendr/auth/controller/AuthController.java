package com.fmellberg.itemlendr.auth.controller;

import com.fmellberg.itemlendr.auth.model.LoginRequest;
import com.fmellberg.itemlendr.auth.model.LoginResponse;
import com.fmellberg.itemlendr.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated LoginRequest request) {
        LoginResponse response = authService.attemptLogin(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }
}
