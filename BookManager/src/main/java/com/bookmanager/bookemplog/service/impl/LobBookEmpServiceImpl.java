package com.bookmanager.bookemplog.service.impl;

import com.bookmanager.bookemplog.dto.LogListDTO;
import com.bookmanager.bookemplog.dto.QueryLogByTimeDTO;
import com.bookmanager.bookemplog.mapper.ILogBookEmpMapper;
import com.bookmanager.bookemplog.service.ILogBookEmpService;
import com.bookmanager.setting.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class LobBookEmpServiceImpl implements ILogBookEmpService {

    @Resource
    private ILogBookEmpMapper logBookEmpMapper;


    /**
     * 最新日志信息20条
     * @return
     */
    @Override
    public Result<List<LogListDTO>> selectNewLog() {
        List<LogListDTO> listDTOS = logBookEmpMapper.selectNewLogInfo();
        if(listDTOS.size()== 0 ){
            return Result.noData();
        }
        return Result.selectSuccess(listDTOS);
    }

    /**
     * 更多日志信息
     * @return
     */
    @Override
    public Result<List<LogListDTO>> selectAllLog() {
        List<LogListDTO> listDTOS = logBookEmpMapper.selectAllLogInfo();
        if(listDTOS.size()== 0 ){
            return Result.noData();
        }
        return Result.selectSuccess(listDTOS);
    }

    @Override
    public Result<List<LogListDTO>> selectLogByJobNumber(Integer jobNumber) {
        List<LogListDTO> SelfInfo = logBookEmpMapper.selectLogInfoByJobNumber(jobNumber);
        if(SelfInfo.size()== 0 ){
            return Result.noData();
        }
        return Result.selectSuccess(SelfInfo);
    }

    @Override
    public Result<List<LogListDTO>> selectEmpLogByTime(QueryLogByTimeDTO qlt) {
        List<LogListDTO> empLog = logBookEmpMapper.selectSelfByTime(qlt.getJobNumber(),qlt.getStartTime(),qlt.getEndTime());
        if(empLog.size()== 0 ){
            return Result.noData();
        }
        return Result.selectSuccess(empLog);
    }

    @Override
    public Result<List<LogListDTO>> selectLogByTime(QueryLogByTimeDTO qlt) {
        List<LogListDTO> allLog = logBookEmpMapper.selectAllLogByTime(qlt.getStartTime(),qlt.getEndTime());
        if(allLog.size()== 0 ){
            return Result.noData();
        }
        return Result.selectSuccess(allLog);
    }
}
