package com.bookmanager.user.mapper;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.model.EmployeeExample;
import java.util.List;

import com.bookmanager.user.dto.SelectAllEmpDTO;
import com.bookmanager.user.dto.SelectEmailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EmployeeMapper {

    String selectEmailByJobNumber(Integer jobNumber);

    String getNicknameByJobNumber(Integer jobNumber);

    List<SelectEmailDTO> selectEmpByRole(Integer role);

    String selectByEmail(String email);

    Long countByExample(EmployeeExample example);

    Integer deleteByExample(EmployeeExample example);

    Integer deleteByPrimaryKey(Long id);

    Integer insert(Employee record);

    Integer insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Long id);

    SelectAllEmpDTO selectEmpByUsername(String username );

    Employee selectEmpByUsernameAndPassword(@Param("username") String username );

    String selectPasswordByUsername(String username);

    Integer updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    Integer updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    Integer updateByPrimaryKeySelective(Employee record);

    Integer updateByPrimaryKey(@Param("record") Employee record);

    Integer selectEmpByJobNumber(Integer jobNumber);

    Integer deleteEmpByJobNumber(@Param("jobNumber") Integer jobNumber,@Param("role") Integer role,@Param("phone") String phone);

    void updatePasswordByUsername(@Param("username") String username,@Param("password") String newPsw);

    List<SelectAllEmpDTO> selectAllEmp(Integer ROLE);

    SelectAllEmpDTO  selectByJobNumber(Integer jobNumber);
}