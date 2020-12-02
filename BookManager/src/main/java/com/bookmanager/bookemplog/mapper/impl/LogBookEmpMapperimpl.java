package com.bookmanager.bookemplog.mapper.impl;

import com.bookmanager.bookemplog.mapper.LogBookEmpMapper;
import com.bookmanager.setting.model.LogBookEmp;
import com.bookmanager.setting.model.LogBookEmpExample;

import java.util.List;

public class LogBookEmpMapperimpl implements LogBookEmpMapper {
    @Override
    public long countByExample(LogBookEmpExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(LogBookEmpExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(LogBookEmp record) {
        return 0;
    }

    @Override
    public int insertSelective(LogBookEmp record) {
        return 0;
    }

    @Override
    public List<LogBookEmp> selectByExample(LogBookEmpExample example) {
        return null;
    }

    @Override
    public LogBookEmp selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(LogBookEmp record, LogBookEmpExample example) {
        return 0;
    }

    @Override
    public int updateByExample(LogBookEmp record, LogBookEmpExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(LogBookEmp record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(LogBookEmp record) {
        return 0;
    }
}
