package com.bookmanager.setting.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bookmanager.user.dto.SelectAllEmpDTO;
import org.springframework.stereotype.Service;

@Service
public class CreatToken {

    public static  String getToken(SelectAllEmpDTO emp) {
        String token="";
        token= JWT.create().withAudience(emp.getJobNumber().toString())
                .sign(Algorithm.HMAC256(emp.getUsername()));
        return token;
    }
}
