package com.tm30.tango.config.email.eventPublisher;

import com.tm30.tango.entities.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ResetPasswordEvent extends ApplicationEvent {

    private final String otp;
    private final User user;

    public ResetPasswordEvent(Object source, User user, String otp) {
        super(source);
        this.user = user;
        this.otp = otp;
    }
}
