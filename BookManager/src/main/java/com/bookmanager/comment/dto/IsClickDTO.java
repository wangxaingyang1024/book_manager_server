package com.bookmanager.comment.dto;

import lombok.Data;

@Data
public class IsClickDTO {

    private String myFlag;

    private Boolean isLike;

    private Integer likeCount ;

    private Integer jobNumber ;

    private Integer isbn ;
}
