package com.bookmanager.book.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookTypeDTO {

    private Integer mid;

    private Integer pid;

    private String name ;

    private Integer level ;
    //内联查询
    private List<BookTypeDTO> children ;
}
