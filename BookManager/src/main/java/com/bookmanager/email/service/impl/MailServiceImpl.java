package com.bookmanager.email.service.impl;

import com.bookmanager.email.config.MailSenderConfig;
import com.bookmanager.email.mapper.EmailMapper;
import com.bookmanager.email.service.MailService;
import com.bookmanager.setting.util.DisposeNumber;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.SelectAllEmpDTO;
import com.bookmanager.user.dto.SelectEmailDTO;
import com.bookmanager.user.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final MailSenderConfig senderConfig;

    @Resource
    private EmailMapper mapper ;

    @Autowired
    private TaskExecutor taskExecutor ;

    @Resource
    private EmployeeMapper employeeMapper ;

    @Override
    public Result sendMailVerify(String email) {
        String i = employeeMapper.selectByEmail(email);
        if (i != null) {
            return new Result(CodeEnum.EMAIL_DISABLED);
        }
        emailAsync(email);
        return new Result(CodeEnum.SELECT_SUCCESS);
    }

    @Async("threadPoolTaskExecutor")
    public void emailAsync(String email){
        taskExecutor.execute(() ->{
            try {
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
            } catch (MailException e) {
                log.warn("发送邮件消息验证失败=exception:{}", e);
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean sendMailList(List<SelectEmailDTO> emailList){
        MailList(emailList);
        return true ;
    }
    @Async("threadPoolTaskExecutor")
    public void MailList(List<SelectEmailDTO> emailList) {
        taskExecutor.execute(() ->{
            try {
                JavaMailSenderImpl mailSender = senderConfig.getSender();
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom(Objects.requireNonNull(mailSender.getUsername()));
                emailList.forEach(email ->{
                    message.setTo(email.getEmail());
                    message.setSubject("【明日图书馆通知】");
                    if(email.getFlag() == 1){
                        message.setText("亲爱的员工，您好！\n        您所关注的图书可借阅了，赶紧去借阅吧！");
                    }
                    message.setText("亲爱的员工，您好！\n        书架又上新书了，可能有你的最爱呦，赶紧去借阅吧！");
                    mailSender.send(message);
                });

            } catch (MailException e) {
                log.warn("发送邮件消息失败=exception:{}", e);
                e.printStackTrace();
            }
        });
    }

    @Override
    public Result verifyEmail(String email) {
        return null;
    }
}