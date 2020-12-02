package com.bookmanager.bookemplog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class LogListDTO {

    private String nickName ;    //昵称

    private Integer jobNumber;    //工号

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //借出时间
    private Date lendTime;

    private String bookName;    //书名

    private Long isbn;      //国际标准书号

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //归还时间
    private Date returnTime;

}
