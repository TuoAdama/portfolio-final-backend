package com.portfolio.adama.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    public record Mail(String to, String subject,  String body) {
    }

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.to);
        message.setSubject(mail.subject);
        message.setText(mail.body);
        mailSender.send(message);
    }
}
