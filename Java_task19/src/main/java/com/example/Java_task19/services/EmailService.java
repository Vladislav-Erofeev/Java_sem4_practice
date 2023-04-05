package com.example.Java_task19.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    private final MailSender mailSender;
    private final String FROM;

    @Autowired
    public EmailService(MailSender mailSender, @Value("${spring.mail.username}") String from) {
        this.mailSender = mailSender;
        FROM = from;
    }

    @Async
    public void sendEmail(String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(FROM);
        simpleMailMessage.setTo("20031911@mail.ru");
        simpleMailMessage.setSubject("Test mail");
        simpleMailMessage.setText(text);
        mailSender.send(simpleMailMessage);
    }
}
