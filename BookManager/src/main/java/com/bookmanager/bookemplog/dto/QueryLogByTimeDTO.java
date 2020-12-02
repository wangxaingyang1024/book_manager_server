package com.bookmanager.bookemplog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QueryLogByTimeDTO {

    private Integer jobNumber ;

    private Date startTime;

    private Date endTime ;
}
