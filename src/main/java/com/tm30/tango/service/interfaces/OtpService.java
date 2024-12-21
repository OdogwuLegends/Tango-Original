package com.tm30.tango.service.interfaces;

import com.tm30.tango.entities.Otp;
import com.tm30.tango.entities.User;

import java.util.Optional;

public interface OtpService {
    Otp create(Otp otp);
    Optional<Otp> findByOtpUserId(String userId);
    Optional<Otp> findByToken(String token);
    User findUserByOtpUserId(String otpUserId);
    boolean isOtpExpired(Otp otpEntity);
    boolean isOtpInvalid(Otp otpEntity, String otp);
}
