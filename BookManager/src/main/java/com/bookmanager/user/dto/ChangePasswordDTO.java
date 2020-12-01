package com.bookmanager.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改密码——表单提交的数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDTO {
    private String username;
    private String oldPsw;
    private String newPsw;
}
