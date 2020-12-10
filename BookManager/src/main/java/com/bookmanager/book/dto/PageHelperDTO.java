package com.bookmanager.book.dto;

import lombok.Data;

@Data
public class PageHelperDTO {

    private Integer pageNum  = 1 ;

    private Integer pageSize ;

    private String name ;
}
