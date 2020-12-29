package com.bookmanager.favorite.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

@Data
public class FavoriteDTO {

    private Integer isbn ;

    private Integer jobNumber ;

    private Boolean isClick;
}
