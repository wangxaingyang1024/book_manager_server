package com.bookmanager.bookemplog.service;

import com.bookmanager.bookemplog.dto.LogListDTO;
import com.bookmanager.bookemplog.dto.QueryLogByTimeDTO;
import com.bookmanager.setting.vo.Result;

import java.util.List;

public interface ILogBookEmpService {

    //查询最新日志信息 最多显示20条，倒序
    Result<List<LogListDTO>> selectNewLog();
    //展示更多，查询所有日志信息.
    Result<List<LogListDTO>> selectAllLog();
    //查询指定用户借书还书信息
    Result<List<LogListDTO>> selectLogByJobNumber(Integer jobNumber);
    //todo：查询自定图书被借阅信息
//    Result<List<LogListDTO>> selectNewLog();

    //todo:根据时间端查询指定时间之内的个人日志信息
    Result<List<LogListDTO>> selectEmpLogByTime(QueryLogByTimeDTO qlt);
    //管理员查询所有日志信息
    Result<List<LogListDTO>> selectLogByTime(QueryLogByTimeDTO qlt);

}
