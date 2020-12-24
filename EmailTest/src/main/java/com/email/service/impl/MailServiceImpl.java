package com.email.service.impl;

import com.email.config.MailSenderConfig;
import com.email.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailSenderConfig senderConfig;

    @Override
    public boolean sendMail() {

        JavaMailSenderImpl mailSender = senderConfig.getSender();

        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(Objects.requireNonNull(mailSender.getUsername()));
        //邮件接收人
        message.setTo("614200664@qq.com");
        //邮件主题
        message.setSubject("测试邮件");
        //邮件内容
        message.setText("测试邮件内容");
        //发送邮件
        mailSender.send(message);

        return true;
    }
}