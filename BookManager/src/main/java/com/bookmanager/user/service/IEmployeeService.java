package com.bookmanager.user.service;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.EmployeeDTO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface IEmployeeService {

    //管理员登录
    public Result adminEmpLogin(EmployeeDTO employeeDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException;
     //用户登录
    public Result publicEmpLogin(EmployeeDTO employeeDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    //注册
    public Result addEmployee(Employee employee) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    //用户信息
}
