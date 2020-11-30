package com.bookmanager.user.service.impl;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.util.MyMD5Util;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.EmployeeDTO;
import com.bookmanager.user.mapper.EmployeeMapper;
import com.bookmanager.user.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private EmployeeMapper mapper ;


    /**管员登录
     *
     * @param employeeDTO
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @Override
    public Result<Employee> adminEmpLogin(EmployeeDTO employeeDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Employee emp = mapper.selectEmpByUsername(employeeDTO.getUsername());
        log.info(emp.toString());
        if (emp.getRole() != 2){
            return Result.notPower();
        }
        if(emp == null){
            return Result.badUsernameRequest();
        }
        String passwordInDb = mapper.selectPasswordByUsername(employeeDTO.getUsername());
        if(MyMD5Util.validPassword(employeeDTO.getPassword(),passwordInDb)){
            return Result.adminSuccess(emp);
        }
        return Result.badPasswordRequest();
    }
    /**
     * 用户登录
     */
    public Result<Employee> publicEmpLogin(EmployeeDTO employeeDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Employee emp = mapper.selectEmpByUsername(employeeDTO.getUsername());
        log.info(emp.toString());
        if(emp == null){
            return Result.badUsernameRequest();
        }
        String passwordInDb = mapper.selectPasswordByUsername(employeeDTO.getUsername());
        if(MyMD5Util.validPassword(employeeDTO.getPassword(),passwordInDb)){
            return Result.success(emp);
        }
        return Result.badPasswordRequest();
    }
    /**
     * 用户注册
     * @param employee
     * @return
     */
    @Override
    public Result<Employee> addEmployee(Employee employee) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Employee emp = mapper.selectEmpByUsername(employee.getUsername());
        if(emp != null){
            return Result.empExist();
        }
        employee.setPassword(MyMD5Util.getEncryptedPwd(employee.getPassword()));
        employee.setJobNumber(MyUUID());
        mapper.insertSelective(employee);
        return new Result<>(CodeEnum.SIGNUP_SUCCESS);
    }


    /**
     * 随机生成job_number；
     */
    public static Integer MyUUID(){
        StringBuilder str=new StringBuilder();//定义变长字符串bai
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<8;i++){
            str.append(random.nextInt(10));
        }
        //将字符串转换为数字并du输出
        return  Integer.parseInt(str.toString());

    }
}
