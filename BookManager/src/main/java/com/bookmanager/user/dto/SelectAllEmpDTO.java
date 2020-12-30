package com.bookmanager.user.dto;

import jdk.nashorn.internal.parser.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectAllEmpDTO {
    private Integer jobNumber;

    private String username;

    private String nickName;

    private Integer gender;

    private String phone;

    private Date birth;

    private Integer role;

    private String email ;

    private String token ;

}
