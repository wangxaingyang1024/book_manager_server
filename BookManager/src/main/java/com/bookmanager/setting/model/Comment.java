package com.bookmanager.setting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    //员工编号
    private Integer myNumber;
    private Integer parNumber;

    private Integer isbn;

    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;
    //点赞数
    private Integer likeCount;
    //评论信息标识
    private String myFlag ;
    private String parFlag ;
}
