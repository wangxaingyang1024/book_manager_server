package com.bookmanager.comment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Integer myNumber;
    private Integer parNumber;
    private Integer isbn;
    private String message;
    private Date commentTime;
    private Integer likeCount;
}
