package com.bookmanager.book.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RelationBookEmpDTO {
    private Integer jobNumber; //用户编号
    private Long isbn; //图书编号
    private Date currentTime;
}
