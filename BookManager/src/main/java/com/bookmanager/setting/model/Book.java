package com.bookmanager.setting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Book {
    private Long id;

    private Long isbn;

    private String name;

    private String author;

    private Integer type;

    private Boolean status;

    private String synopsis;

}