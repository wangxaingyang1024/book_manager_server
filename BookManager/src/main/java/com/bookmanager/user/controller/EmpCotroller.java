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

    /**
     * 普通登录
     * @param employee
     * @return
     */
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

    /**
     * 密码修改
     * @param cDTO
     * @return
     */
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

    /**
     * 个人信息查询
     * @param jobNumber
     * @return
     */
    @GetMapping("profile/{jobNumber}")
    public Result profile(@PathVariable Integer jobNumber){
        return employeeService.getProfile(jobNumber);
    }

    /**
     * 个人信息修改
     * @param emp
     * @return
     */
    @PutMapping("upProfile")
    public Result upProfile(@RequestBody Employee emp){
        return employeeService.updateSelfInformation(emp);
    }

}
