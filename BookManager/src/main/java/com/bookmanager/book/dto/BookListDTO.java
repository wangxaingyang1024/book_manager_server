package com.bookmanager.book.dto;

import lombok.Data;

@Data
public class BookListDTO {
    private Long id;

    private Long isbn;

    private String name;

    private String author;

    private String type;

    private Boolean status;

    private String synopsis;

    private Integer[] level = new Integer[3];

    private Boolean isClick ;
}
