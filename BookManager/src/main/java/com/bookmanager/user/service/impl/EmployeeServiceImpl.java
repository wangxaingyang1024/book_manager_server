package com.bookmanager.user.service.impl;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.token.CreatToken;
import com.bookmanager.setting.util.MD5Util;
import com.bookmanager.setting.util.DisposeNumber;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.ChangePasswordDTO;
import com.bookmanager.user.dto.EmpLoginDTO;
import com.bookmanager.user.dto.SelectAllEmpDTO;
import com.bookmanager.user.mapper.EmployeeMapper;
import com.bookmanager.user.service.IEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import static com.bookmanager.setting.vo.Result.selectSuccess;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {
     //管理员角色
    private static final Integer ADMIN_ROLE = 2;
    private static final Integer ROLE = 1;
    private static final Integer DELETE_ROLE = 0;

    @Resource
    private EmployeeMapper mapper ;

    /**
     * 查询个人信息
     * @param jobNumber
     * @return
     */
    @Override
    public Result<SelectAllEmpDTO> getProfile(Integer jobNumber) {
        SelectAllEmpDTO  employee = mapper.selectByJobNumber(jobNumber);
        return new Result(CodeEnum.SELECT_SUCCESS ,employee);
    }

    //查询所有用户信息
    @Override
    public Result selectAllEmp(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SelectAllEmpDTO> employees = mapper.selectAllEmp(ROLE);
        if (employees.size() == 0 ){
            return new Result(CodeEnum.NOT_EMP_REGISTER,-1);
        }
        PageInfo<SelectAllEmpDTO> pageInfo = new PageInfo<>(employees);
        return selectSuccess(pageInfo);
    }
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
     * @param employee
     * @return
     */
    @Override
    public Result updateSelfInformation(Employee employee) {
        Integer jobNumber1 = mapper.selectEmpByJobNumber(employee.getJobNumber());
        if(jobNumber1 == null){
            return  new Result(CodeEnum.EMP_NOTEXIST);
        }
        mapper.updateByPrimaryKey(employee);
        return new Result(CodeEnum.UPDATE_SUCCESS);
    }

    //TODO:用户注销账号

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
        mapper.deleteEmpByJobNumber(jobNumber,DELETE_ROLE," ");
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
    public Result<SelectAllEmpDTO > adminEmpLogin(EmpLoginDTO empLoginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SelectAllEmpDTO  emp = mapper.selectEmpByUsername(empLoginDTO.getUsername());
        log.info(emp.toString());
        if (emp.getRole() != ADMIN_ROLE){
            return Result.notPower();
        }
        if(emp == null){
            return Result.badUsernameRequest();
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
    public Result<SelectAllEmpDTO> publicEmpLogin(EmpLoginDTO empLoginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SelectAllEmpDTO emp = mapper.selectEmpByUsername(empLoginDTO.getUsername());
        log.info(emp.toString());
        if(emp == null){
            return Result.badUsernameRequest();
        }
        if(emp.getRole() == 0 ){
            return new Result(CodeEnum.EMP_NOTEXIST);
        }
        String passwordInDb = mapper.selectPasswordByUsername(empLoginDTO.getUsername());
        if(MD5Util.validPassword(empLoginDTO.getPassword(),passwordInDb)){
            //token验证
            String token = CreatToken.getToken(emp);
            emp.setToken(token);
            return Result.success(emp);
        }
        return Result.badPasswordRequest();
    }
//
//    /**
//     * 注销
//     * @param request
//     * @return
//     */
//    public String logout(HttpServletRequest request) {
//        String token = request.getHeader("token");
//        Boolean delete = redisService.delete(token);
//        if (!delete) {
//            return "注销失败，请检查是否登录！";
//        }
//        return "注销成功！";
//    }
    /**
     * 用户注册
     * @param employee
     * @return
     */
    @Override
    public Result<Employee> addEmployee(Employee employee) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SelectAllEmpDTO  emp = mapper.selectEmpByUsername(employee.getUsername());
        if(emp != null){
            return Result.empExist();
        }
        Integer jobNumber = Integer.parseInt(DisposeNumber.NumberUUID(8));
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

}
