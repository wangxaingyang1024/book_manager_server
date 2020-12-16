package com.bookmanager.bookemplog.controller;

import com.bookmanager.bookemplog.dto.LogListDTO;
import com.bookmanager.bookemplog.dto.QueryLogByTimeDTO;
import com.bookmanager.bookemplog.service.ILogBookEmpService;
import com.bookmanager.setting.token.UserLoginToken;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/log/")
public class LogBookEmpController {

    @Autowired
    private ILogBookEmpService logBookEmpService ;

    /**
     * 查询最新日志记录
     * @return
     */
    @UserLoginToken
    @GetMapping("admin/newLogs")
    public Result queryNewLog(){
        return logBookEmpService.selectNewLog();
    }

    /**
     * 更多日志信息
     * @return
     */
    @UserLoginToken
    @GetMapping("admin/allLogs")
    public Result queryAllLog(){
        return logBookEmpService.selectAllLog();
    }

    /**
     * 查询某一个人的日志记录
     * @param jobNumber
     * @return
     */
    @UserLoginToken
    @PostMapping("admin/queryOne")
    public Result<List<LogListDTO>> queryByJobNumber(@RequestBody String jobNumber){
        return logBookEmpService.selectLogByJobNumber(Integer.parseInt(jobNumber));
    }

    /**
     * 个人详情页的日志记录
     * @param qlt
     * @return
     */
    @UserLoginToken
    @PostMapping("logT")
    public Result<List<LogListDTO>> queryOneByTime(@RequestBody QueryLogByTimeDTO qlt){
        return logBookEmpService.selectEmpLogByTime(qlt);
    }

    /**
     * 查询指定时间段内的所有日志
     * @param qlt
     * @return
     */
    @UserLoginToken
    @PostMapping("admin/logT")
    public Result<List<LogListDTO>> queryAllByTime(@RequestBody  QueryLogByTimeDTO qlt){
        return logBookEmpService.selectLogByTime(qlt);
    }

}
