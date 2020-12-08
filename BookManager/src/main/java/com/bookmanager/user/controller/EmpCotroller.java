package com.bookmanager.user.controller;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.ChangePasswordDTO;
import com.bookmanager.user.dto.EmpLoginDTO;
import com.bookmanager.user.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/")
public class EmpCotroller {

    @Autowired
    private IEmployeeService employeeService ;


    @PostMapping("login")
    public Result<Employee> login(@RequestBody EmpLoginDTO employee) {
        try {
            return employeeService.publicEmpLogin(employee);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new Result(CodeEnum.LOGIN_FAILURE) ;
    }

    /**
     * 用户注册
     * @param employee
     * @return
     */
    @PostMapping("signUp")
    public Result signUp(@RequestBody Employee employee) {
        try {
            return employeeService.addEmployee(employee);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new Result(CodeEnum.SIGNUP_FAILURE) ;
    }

    //修改密码
    @PostMapping("changePsw")
    public  Result changePassword(@RequestBody ChangePasswordDTO cDTO){
        try {
            return employeeService.updatePassword(cDTO);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new Result(CodeEnum.CHANGE_PASSWORD_FAILURE) ;
    }

}
