package com.bookmanager.setting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;

    private Long isbn;

    private String name;

    private String author;

    private String type;

    private Long empNumber;

    private Boolean status;

    private String synopsis;

}