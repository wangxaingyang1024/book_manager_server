package com.bookmanager.user.controller;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.EmployeeDTO;
import com.bookmanager.user.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
public class AdminEmpController {

    @Autowired
    private IEmployeeService employeeService ;


    //更新自己的信息
    //管理员删除用户
    //管理员添加图书
    //管理员删除图书
    //管理员更新图书
    //管理员查询图书

    @PostMapping("/admin/login")
    public Result<Employee> login(@RequestBody EmployeeDTO employee) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return employeeService.adminEmpLogin(employee);
    }
    //删除用户

}
