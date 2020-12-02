package com.bookmanager.user.service;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.ChangePasswordDTO;
import com.bookmanager.user.dto.EmpLoginDTO;
import com.bookmanager.user.dto.SelectAllEmpDTO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IEmployeeService {

    //管理员登录
    Result adminEmpLogin(EmpLoginDTO empLoginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException;
     //用户登录
    Result publicEmpLogin(EmpLoginDTO empLoginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    //注册
    Result  addEmployee(Employee employee) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    //用户信息
    //删除用户信息
    Result deleteEmployee(Integer jobNumber);

    //用户自己更新信息
    Result updateSelfInformation(Integer jobNumber,Employee employee);

    //用户修改密码
    Result updatePassword(ChangePasswordDTO cDto) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    //查询所有用户列表
    public Result<List<SelectAllEmpDTO>> selectAllEmp();
}
