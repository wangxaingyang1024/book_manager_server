package com.bookmanager.favorite.dto;

import lombok.Data;

@Data
public class AllFavoriteDTO {
        private Long isbn;

        private String name;

        private String author;

        private String type;

        private Boolean status;

        private String synopsis;
}
