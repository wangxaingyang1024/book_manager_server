package com.bookmanager.email.service;

import com.bookmanager.email.dto.EmailDTO;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.SelectEmailDTO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface MailService {

    /**
     * 发送邮件
     * @return 返回 true 或者 false
     */
    Result sendMailVerify(String email);

    Boolean sendMailList(List<SelectEmailDTO> emailList);

    Result verifyEmail(String email);



}
