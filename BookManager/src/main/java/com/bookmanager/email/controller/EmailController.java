package com.bookmanager.email.controller;

import com.bookmanager.email.dto.EmailDTO;
import com.bookmanager.email.service.MailService;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email/")
public class EmailController {

    @Autowired
    private MailService service ;

    @PostMapping("verify")
    public Result verifyEmail(@RequestBody EmailDTO email){
       return  service.sendMailVerify(email.getEmail());
    }
}
