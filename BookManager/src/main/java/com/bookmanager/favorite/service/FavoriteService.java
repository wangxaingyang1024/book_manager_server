package com.bookmanager.favorite.service;


import com.bookmanager.favorite.dto.FavoriteDTO;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.SelectEmailDTO;

import java.util.List;

public interface FavoriteService {

    List<SelectEmailDTO> getAllLikeBook(Integer isbn);

    Result favoriteBook(FavoriteDTO fd);

    Result getFavoriteBook(Integer jobNumber);

    //当前用户的收藏
    Result getLike(FavoriteDTO favoriteDTO);
}
