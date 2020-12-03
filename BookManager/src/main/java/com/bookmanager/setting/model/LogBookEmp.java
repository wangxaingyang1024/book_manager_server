package com.bookmanager.setting.model;

import lombok.Data;

import java.util.Date;

@Data
public class LogBookEmp {
    private Integer id;

    private Date lendTime;

    private Date returnTime;

    private Long bookIsbn;

    private Integer jobNumber ;

}