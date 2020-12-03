package com.bookmanager.bookemplog.controller;

import com.bookmanager.bookemplog.dto.LogListDTO;
import com.bookmanager.bookemplog.dto.QueryLogByTimeDTO;
import com.bookmanager.bookemplog.service.ILogBookEmpService;
import com.bookmanager.setting.vo.CodeEnum;
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
    @GetMapping("admin/newLogs")
    public Result queryNewLog(){
        return logBookEmpService.selectNewLog();
    }

    /**
     * 更多日志信息
     * @return
     */
    @GetMapping("admin/allLogs")
    public Result queryAllLog(){
        return logBookEmpService.selectAllLog();
    }

    /**
     * 查询某一个人的日志记录
     * @param jobNumber
     * @return
     */
    @PostMapping("admin/queryOne")
    public Result<List<LogListDTO>> queryByJobNumber(@RequestBody String jobNumber){
        return logBookEmpService.selectLogByJobNumber(Integer.parseInt(jobNumber));
    }
    //TODO:个人详情页的日志记录
    @PostMapping("logT")
    public Result<List<LogListDTO>> queryOneByTime(@RequestBody QueryLogByTimeDTO qlt){
        return logBookEmpService.selectEmpLogByTime(qlt);
    }

    /**
     * 查询指定时间段内的所有日志
     * @param qlt
     * @return
     */
    @PostMapping("admin/logT")
    public Result<List<LogListDTO>> queryAllByTime(@RequestBody  QueryLogByTimeDTO qlt){
        return logBookEmpService.selectLogByTime(qlt);
    }

}
