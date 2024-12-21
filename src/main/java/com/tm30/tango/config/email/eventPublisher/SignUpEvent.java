package com.tm30.tango.config.email.eventPublisher;

import com.tm30.tango.entities.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SignUpEvent extends ApplicationEvent {
    private final User user;
    private final String password;

    public SignUpEvent(Object source, User user, String password) {
        super(source);
        this.user = user;
        this.password = password;
    }
}
