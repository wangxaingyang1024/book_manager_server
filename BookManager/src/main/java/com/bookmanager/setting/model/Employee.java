package com.bookmanager.setting.model;

import lombok.*;

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

    private Integer age;

    private Integer role;

    public Employee(String username ,String password){
        this.username = username ;
        this.password = password ;
    }
}