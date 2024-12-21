package com.tm30.tango.config.email.eventPublisher;

import com.tm30.tango.config.email.emailConfig.EmailService;
import com.tm30.tango.entities.User;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;

@Component
@AllArgsConstructor
@Slf4j
public class SignUpListener implements ApplicationListener<SignUpEvent> {
    private final EmailService emailService;
    private final TemplateEngine templateEngine;

    // @SneakyThrows
    @Override
    public void onApplicationEvent(SignUpEvent event) {
        User user = event.getUser();
        String body = "Welcome to Tango";

        final Context context = new Context(LocaleContextHolder.getLocale());
        context.setVariable("email", user.getEmail());
        context.setVariable("name", user.getName());
        context.setVariable("password", event.getPassword());

        final String htmlContent = templateEngine.process("welcome", context);

        log.info("Sending email to {}", user.getEmail());
        emailService.sendEmail(user.getEmail().toLowerCase(), body, htmlContent);
    }
}
