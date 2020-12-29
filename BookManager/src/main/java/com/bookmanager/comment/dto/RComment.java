package com.bookmanager.comment.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RComment {
    private Integer myNumber;
    private Integer parNumber;
    private Integer isbn;
    private String message;
    private String commentTime;
    private Integer likeCount;
    private String myFlag;
    private String parFlag;
    private String myNickname;
    private String parNickname;
    private List<RComment> children;
}
