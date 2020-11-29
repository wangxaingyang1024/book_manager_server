package com.bookmanager.setting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;

    private Integer jobNumber;

    private String username;

    private String password;

    private String nickName;

    private Integer gender;

    private String phone;

    private Integer age;

    private Integer role;
}