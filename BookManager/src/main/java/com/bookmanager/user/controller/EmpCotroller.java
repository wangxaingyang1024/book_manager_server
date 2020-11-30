package com.bookmanager.user.controller;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.EmployeeDTO;
import com.bookmanager.user.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
public class EmpCotroller {

    @Autowired
    private IEmployeeService employeeService ;


    @PostMapping("/login")
    public Result<Employee> login(@RequestBody EmployeeDTO employee) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return employeeService.publicEmpLogin(employee);
    }
    @PostMapping("/signUp")
    public Result signUp(@RequestBody Employee employee) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return employeeService.addEmployee(employee);
    }

}
