package com.tm30.tango.service.interfaces;

import com.tm30.tango.dtos.LoginDto;
import com.tm30.tango.dtos.PasswordDto;
import com.tm30.tango.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

public interface AuthService {
    ResponseEntity<ApiResponse<?>> login(LoginDto.Request request);
    ResponseEntity<ApiResponse<?>> changePassword(Principal principal,PasswordDto.ChangePassword request);
    ResponseEntity<ApiResponse<?>> initiatePasswordReset(PasswordDto.InitiatePasswordReset request);
    ResponseEntity<ApiResponse<?>> completePasswordReset(PasswordDto.CompletePasswordReset request);
}
