package com.bookmanager.email.service.impl;

import com.bookmanager.email.config.MailSenderConfig;
import com.bookmanager.email.mapper.EmailMapper;
import com.bookmanager.email.service.MailService;
import com.bookmanager.setting.util.DisposeNumber;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailSenderConfig senderConfig;

    @Resource
    private EmailMapper mapper ;

    @Override
    public Result sendMailVerify(String email) {

        JavaMailSenderImpl mailSender = senderConfig.getSender();
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Objects.requireNonNull(mailSender.getUsername()));
        message.setTo(email);
        message.setSubject("【明日图书馆】邮箱注册验证");
        String verifyCode = DisposeNumber.NumberUUID(6);
        message.setText("【明日图书馆】:\n     邮箱注册验证码：" + verifyCode + "。图书管理员绝不会索取验证码，切勿转发或告知他人！");
        mailSender.send(message);
        mapper.insertEmail(email,verifyCode);
        return new Result(CodeEnum.SELECT_SUCCESS);
    }

    @Override
    public boolean sendMailList() {
        JavaMailSenderImpl mailSender = senderConfig.getSender();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Objects.requireNonNull(mailSender.getUsername()));
        message.setTo("614200664@qq.com");
        message.setSubject("测试邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
        return true;
    }

    @Override
    public Result verifyEmail(String email) {
        return null;
    }
}