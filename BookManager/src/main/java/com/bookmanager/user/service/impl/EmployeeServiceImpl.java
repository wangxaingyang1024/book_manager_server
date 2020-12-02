package com.bookmanager.user.service.impl;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.util.MD5Util;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.ChangePasswordDTO;
import com.bookmanager.user.dto.EmpLoginDTO;
import com.bookmanager.user.dto.SelectAllEmpDTO;
import com.bookmanager.user.mapper.EmployeeMapper;
import com.bookmanager.user.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import static com.bookmanager.setting.vo.Result.selectSuccess;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {
     //管理员角色
    private static final Integer ADMIN_ROLE = 2;

    @Resource
    private EmployeeMapper mapper ;

    //查询所有用户信息
    @Override
    public Result<List<SelectAllEmpDTO>> selectAllEmp() {
        List<SelectAllEmpDTO> employees = mapper.selectAllEmp();
        if (employees.size() == 0 ){
            return new Result(CodeEnum.NOT_EMP_REGISTER,-1);
        }
        return selectSuccess(employees);
    }

    //查询制定用户信息


    //TODO:手机验证：待做
    /**
     * 用户修改密码
     * @param cDto
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @Override
    public Result updatePassword(ChangePasswordDTO cDto) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Employee employee = mapper.selectEmpByUsernameAndPassword(cDto.getUsername());
        if(employee == null ){
            return new Result(CodeEnum.PLEASE_REGISTER);
        }
        if(!MD5Util.validPassword(cDto.getOldPsw(),employee.getPassword())){
            return new Result(CodeEnum.OLDPASSWORD_ERROR);
        }
        String pwd = MD5Util.getEncryptedPwd(cDto.getNewPsw());
        mapper.updatePasswordByUsername(cDto.getUsername(),pwd);
        return new Result(CodeEnum.CHANGE_PASSWORD_SUCCESS);
    }

    /**
     * 用户自己更新自己的信息
     * @param jobNumber
     * @param employee
     * @return
     */
    @Override
    public Result updateSelfInformation(Integer jobNumber,Employee employee) {
        Integer jobNumber1 = mapper.selectEmpByJobNumber(jobNumber);
        if(jobNumber1 == null){
            return  new Result(CodeEnum.EMP_NOTEXIST);
        }
        mapper.updateByPrimaryKey(employee);
        return new Result(CodeEnum.UPDATE_SUCCESS);
    }

    //TODO:用户注销账号：待做

    /**
     *    //管理员删除用户
     * 当用户不再使用之后进行清理，一般不适用，用户可以自己进行注销账号
     * @param jobNumber
     * @return
     */
    @Override
    public Result deleteEmployee(Integer jobNumber) {
        Integer jn = mapper.selectEmpByJobNumber(jobNumber);
        if(jn == null){
            return  new Result(CodeEnum.EMP_NOTEXIST,-1);
        }
        mapper.deleteEmpByJobNumber(jobNumber);
        return new Result(CodeEnum.DELETE_SUCCESS,jn);
    }

    /**管员登录
     *
     * @param empLoginDTO
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @Override
    public Result<Employee> adminEmpLogin(EmpLoginDTO empLoginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Employee emp = mapper.selectEmpByUsername(empLoginDTO.getUsername());
        if(emp == null){
            return Result.badUsernameRequest();
        }
        if (emp.getRole() != ADMIN_ROLE){
            return Result.notPower();
        }
        String passwordInDb = mapper.selectPasswordByUsername(empLoginDTO.getUsername());
        if(MD5Util.validPassword(empLoginDTO.getPassword(),passwordInDb)){
            return Result.adminSuccess(emp);
        }
        return Result.badPasswordRequest();
    }
    /**
     * 用户登录
     */
    public Result<Employee> publicEmpLogin(EmpLoginDTO empLoginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Employee emp = mapper.selectEmpByUsername(empLoginDTO.getUsername());
        log.info(emp.toString());
        if(emp == null){
            return Result.badUsernameRequest();
        }
        String passwordInDb = mapper.selectPasswordByUsername(empLoginDTO.getUsername());
        if(MD5Util.validPassword(empLoginDTO.getPassword(),passwordInDb)){
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
        Integer jobNumber = JobNumberUUID();
        Integer jn = mapper.selectEmpByJobNumber(jobNumber);
        if(jn != null){
            jobNumber = null ;
            emp = null ;
            addEmployee(employee);
        }
        employee.setJobNumber(jobNumber);
        employee.setPassword(MD5Util.getEncryptedPwd(employee.getPassword()));
        Integer result = mapper.insertSelective(employee);
        return new Result(CodeEnum.SIGNUP_SUCCESS,result);
    }
    /**
     * 随机生成job_number；
     */
    public static Integer JobNumberUUID(){
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
