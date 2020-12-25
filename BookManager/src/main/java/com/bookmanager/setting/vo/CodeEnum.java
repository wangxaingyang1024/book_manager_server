package com.bookmanager.setting.vo;

public enum CodeEnum {

    //book的message
    /**
     *6000开始
     */
    BOOK_ADD_SUCCESS(6000,"添加图书成功！"),
    BOOK_ADD_FAILED(6001,"添加图书失败！"),
    /**
     * 删除
     */
    BOOK_DELETE_SUCCESS(6002,"删除图书成功！"),
    BOOK_DELETE_FAILED (6003,"删除图书失败！"),
    /**
     * 更新图书
     */
    BOOK_UPDATE_SUCCESS(6004,"更新成功！"),
    BOOK_UPDATE_FAILED(6005,"更新失败！"),
    /**
     * 借书
     */
    BOOK_BORROW_SUCCESS(6006,"阅读愉快，请尽快还书哦！"),
    BOOK_BORROW_FAILED(6007,"该书已借出，没有了"),
    /**
     * 还书
     */
    BOOK_RETURN_SUCCESS(6008,"已归还，欢迎下次再来！"),
    BOOK_RETURN_FAILED(6009,"库中没有本书！"),
    /**
     * 查询
     */
    BOOK_find_FAILED(6010,"该用户没有借书！"),
    FIND_BOOKS(6011,"查询成功"),
    /**
     * 获取数据
     */
    SELECT_SUCCESS(200,"ok"),
    SELECT_FAILED(402,"NAN"),
    NO_DATA(400,"还没有数据偶"),
    ADD_FAILED(401,"添加失败！"),
    /**
     * 登录   1000-1020
     */

    LOGIN_SUCCESS(1000, "用户登录成功！"),
    ADMIN_SUCCESS(1001, "管理员登录成功！"),
    CHANGE_PASSWORD_SUCCESS(1002,"密码修改成功！"),
    OLDPASSWORD_ERROR(1003,"原始密码错误！请重新输入～(^∩^)～...."),
    LOGIN_FAILURE(1004,"登录失败！"),
    SIGNUP_FAILURE(1005,"注册失败，服务器跑丢了～(^∩^)～...."),
    CHANGE_PASSWORD_FAILURE(1006,"密码修改失败，服务器串门去了～(^∩^)～...."),
    USER_ERROR(1007,"登录异常!  "),
    /**
     * 参数不齐全或参数错误   2000-2020
     */
    BAD_REQUEST(2000,"参数不正确"),
    TYPE_EXIST(2001,"此类型已经存在！"),

    /**
     * 用户验证名  登录 3000-3020
     */
    BAD_USERNAME_REQUEST(3000,"用户名不存在！"),
    BAD_PASSWORD_REQUEST(3001,"密码错误！"),
    NOT_POWER(3002,"亲，您不是管理员用户偶~~，切勿谋朝篡位丫～(^∩^)～...."),

    /**
     * 注册   3021-3030
     */
    Emp_EXIST(3021,"用户名已存在,请重新输入！"),
    PLEASE_REGISTER(3022,"原始密码或用户名错误，请重新输入..."),
    NOT_EMP_REGISTER(3023,"亲爱的管理员，还没有用户注册偶～(^∩^)～"),
    SIGNUP_SUCCESS(3024,"恭喜你获得新账号，开启你的读书之旅吧∽（^∪^）∽..."),
    /**
     * 删除  3031-3050
     */
    EMP_NOTEXIST(3031,"用户不存在！"),
    UPDATE_SUCCESS(3032,"更新成功！"),
    DELETE_SUCCESS(3033,"删除成功！");


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
