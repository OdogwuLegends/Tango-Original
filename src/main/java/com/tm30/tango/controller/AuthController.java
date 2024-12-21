package com.tm30.tango.controller;

import com.tm30.tango.config.email.emailConfig.EmailService;
import com.tm30.tango.dtos.LoginDto;
import com.tm30.tango.dtos.PasswordDto;
import com.tm30.tango.service.interfaces.AuthService;
import com.tm30.tango.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class AuthController {
    private final AuthService authService;
    private final EmailService emailService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> loginUser(@Valid @RequestBody LoginDto.Request request){
        return authService.login(request);
    }

    @PostMapping("/change-password")
    public ResponseEntity<ApiResponse<?>> changePassword(Principal principal, @Valid @RequestBody PasswordDto.ChangePassword request){
        return authService.changePassword(principal, request);
    }

    @PostMapping("/initiate-password-reset")
    public ResponseEntity<ApiResponse<?>> initiatePasswordReset(@Valid @RequestBody PasswordDto.InitiatePasswordReset request){
        return authService.initiatePasswordReset(request);
    }

    @PostMapping("/complete-password-reset")
    public ResponseEntity<ApiResponse<?>> completePasswordReset(@Valid @RequestBody  PasswordDto.CompletePasswordReset request){
        return authService.completePasswordReset(request);
    }

    @GetMapping("/test-email")
    public ResponseEntity<String> testEmail() {
        emailService.sendEmail("emeralds161996@gmail.com", "Test Subject", "<p>Test Body</p>");
        return ResponseEntity.ok("Email sent!");
    }
}
