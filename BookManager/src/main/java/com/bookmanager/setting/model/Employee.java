package com.bookmanager.setting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private Long id;

    private Integer jobNumber;

    private String username;

    private String password;

    private String nickName;

    private Integer gender;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private Integer role;

    private String email ;

    private String code ;

    public Employee(String username ,String password){
        this.username = username ;
        this.password = password ;
    }
}