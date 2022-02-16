package ru.gb.gbthymeleaf.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShopMailSender {
    private final JavaMailSender javaMailSender;

    public void sendMail(String to, String subject, String text){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("novitsky.mail.shop.geek@gmail.com");
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(text);
        javaMailSender.send(mail);
    }
}
