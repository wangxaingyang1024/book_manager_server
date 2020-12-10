package com.bookmanager.type_level.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookTypeLevelDTO {

    private String name ;

    private Integer level ;

    private Integer pid ;

    private Integer mid ;

    private String cid ; //当前节点下的所有直接子节点
}
