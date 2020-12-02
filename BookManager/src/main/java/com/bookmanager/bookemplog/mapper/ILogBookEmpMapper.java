package com.bookmanager.bookemplog.mapper;

import com.bookmanager.bookemplog.dto.LogListDTO;
import com.bookmanager.setting.model.LogBookEmp;
import com.bookmanager.setting.model.LogBookEmpExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ILogBookEmpMapper {
    long countByExample(LogBookEmpExample example);

    int deleteByExample(LogBookEmpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogBookEmp record);

    int insertSelective(LogBookEmp record);

    List<LogBookEmp> selectByExample(LogBookEmpExample example);

    LogBookEmp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogBookEmp record, @Param("example") LogBookEmpExample example);

    int updateByExample(@Param("record") LogBookEmp record, @Param("example") LogBookEmpExample example);

    int updateByPrimaryKeySelective(LogBookEmp record);

    int updateByPrimaryKey(LogBookEmp record);

    List<LogListDTO> selectNewLogInfo();

    List<LogListDTO> selectAllLogInfo();

    List<LogListDTO> selectLogInfoByJobNumber(Integer jobNumber);

    List<LogListDTO> selectSelfByTime(@Param("jobNumber") Integer jobNumber ,@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<LogListDTO> selectAllLogByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}