package com.bookmanager.setting.vo;

public enum CodeEnum {

    //book的message
    /**
     *6000开始
     */
    BOOK_ADD_SUCCESS(6000,"添加图书成功！"),
    BOOK_ADD_FAILED(6000,"添加图书失败！"),
    /**
     * 删除
     */
    BOOK_DELETE_SUCCESS(6001,"删除图书成功！"),
    /**
     * 更新图书
     */
    BOOK_UPDATE_SUCCESS(6002,"更新成功"),
    BOOK_UPDATE_FAILED(6002,"更新失败"),
    /**
     * 借书
     */
    BOOK_BORROW_SUCCESS(6003,"阅读愉快，请尽快还书哦！"),
    /**
     * 还书
     */
    BOOK_RETURN_SUCCESS(6004,"已归还，欢迎下次再来！"),

    /**
     * 成功
     */
    SUCCESS(1000, "用户登录成功！"),
    ADMIN_SUCCESS(1001, "管理员登录成功！"),
    /**
     * 参数不齐全或参数错误
     */
    BAD_REQUEST(2000,"参数不正确"),
    /**
     * 用户验证名  登录
     */
    BAD_USERNAME_REQUEST(3000,"用户名不存在！"),

    BAD_PASSWORD_REQUEST(3001,"密码错误！"),

    NOT_POWER(3002,"亲，您不是管理员用户偶~~，切勿谋朝篡位丫～(^∩^)～...."),

    /**
     * 注册
     */
    Emp_EXIST(3003,"用户名已存在,请重新输入！"),
    SIGNUP_SUCCESS(3003,"用户名已存在,请重新输入！");



    private Integer code;
    private String message;
    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
