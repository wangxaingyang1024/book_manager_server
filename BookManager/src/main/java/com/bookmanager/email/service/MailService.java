package com.bookmanager.email.service;

import com.bookmanager.email.dto.EmailDTO;
import com.bookmanager.setting.vo.Result;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MailService {

    /**
     * 发送邮件
     * @return 返回 true 或者 false
     */
    Result sendMailVerify(String email);

    boolean sendMailList();

    Result verifyEmail(String email);



}
