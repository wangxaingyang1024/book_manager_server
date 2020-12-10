package com.bookmanager.user.controller;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.ChangePasswordDTO;
import com.bookmanager.user.dto.EmpLoginDTO;
import com.bookmanager.user.dto.SelectAllEmpDTO;
import com.bookmanager.user.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class AdminEmpController {

    @Autowired
    private IEmployeeService employeeService ;


    @PostMapping("login")
    public Result<Employee> login(@RequestBody EmpLoginDTO employee) {
        try {
            return employeeService.adminEmpLogin(employee);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new Result(CodeEnum.LOGIN_FAILURE) ;
    }
    //删除用户
    @PostMapping("remove/{jobNumber}")
    public Result<String> remove(@PathVariable Integer jobNumber){
        return employeeService.deleteEmployee(jobNumber);
    }
    //查询用户列表
    @GetMapping("emps/{pageNum}/{pageSize}")
    public Result emps(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        return employeeService.selectAllEmp(pageNum,pageSize);
    }

}
