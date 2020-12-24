package com.email;

import com.email.service.impl.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApplicationTests {

    @Autowired
    private MailServiceImpl mailService;

    @Test
    public void sendMail() {
        mailService.sendMail();
    }
}
