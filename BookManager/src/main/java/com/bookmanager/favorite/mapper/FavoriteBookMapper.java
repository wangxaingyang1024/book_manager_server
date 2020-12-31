package com.bookmanager.favorite.mapper;

import com.bookmanager.favorite.dto.AllFavoriteDTO;
import com.bookmanager.favorite.dto.FavoriteDTO;
import com.bookmanager.user.dto.SelectEmailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteBookMapper {

    List<SelectEmailDTO> selectJobNumberByIsbn(Integer isbn);

    int insertFavoriteBook(@Param("fd") FavoriteDTO fd);

    int deleteFavoriteBook(@Param("fd") FavoriteDTO fd) ;

    List<AllFavoriteDTO> getFavoriteBook(Integer jobNumber);

    //按照jobNumber和isbn查询是否存在当前用户的收藏
    Integer getAllIsbnByJobNumber(@Param("fDTO") FavoriteDTO favoriteDTO);
}
