package com.bookmanager.favorite.service;


import com.bookmanager.favorite.dto.FavoriteDTO;
import com.bookmanager.setting.vo.Result;

public interface FavoriteService {

    Result favoriteBook(FavoriteDTO fd);

    Result getFavoriteBook(Integer jobNumber);
}
