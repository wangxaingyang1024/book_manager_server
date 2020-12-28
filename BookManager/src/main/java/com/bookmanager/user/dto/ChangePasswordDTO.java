package com.bookmanager.user.dto;

import lombok.Data;

/**
 * 修改密码——表单提交的数据
 */
@Data
public class ChangePasswordDTO {
    private String username;
    private String oldPsw;
    private String newPsw;
}
