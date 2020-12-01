package com.bookmanager.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectAllEmpDTO {
    private Integer jobNumber;

    private String username;

    private String nickName;

    private Integer gender;

    private String phone;

    private Integer age;

    private Integer role;

}
