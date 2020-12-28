package com.bookmanager.setting.model;

import lombok.Data;

@Data
public class BookTypeLevel {
    private Integer id;

    private String name;

    private Integer level;

    private Integer parentId;

    private Integer myId;
}