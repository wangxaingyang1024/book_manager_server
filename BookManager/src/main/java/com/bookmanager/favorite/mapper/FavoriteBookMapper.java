package com.bookmanager.favorite.mapper;

import com.bookmanager.favorite.dto.AllFavoriteDTO;
import com.bookmanager.favorite.dto.FavoriteDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteBookMapper {

    int insertFavoriteBook(@Param("fd") FavoriteDTO fd);

    int deleteFavoriteBook(@Param("fd") FavoriteDTO fd);

    List<AllFavoriteDTO> getFavoriteBook(Integer jobNumber);
}
