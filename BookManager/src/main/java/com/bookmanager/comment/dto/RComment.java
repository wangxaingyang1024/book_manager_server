package com.bookmanager.comment.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RComment {
    private Integer mid;
    private Integer myNumber;
    private Integer parNumber;
    private Integer isbn;
    private String message;
    private String commentTime;
    private Integer likeCount;
    private String myName;
    private String name;
    private String pName;
    private List<RComment> list;
}
