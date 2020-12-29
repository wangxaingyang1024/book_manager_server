package com.bookmanager.favorite.service.impl;

import com.bookmanager.favorite.dto.AllFavoriteDTO;
import com.bookmanager.favorite.dto.FavoriteDTO;
import com.bookmanager.favorite.mapper.FavoriteBookMapper;
import com.bookmanager.favorite.service.FavoriteService;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class FavoriteBookServiceImp implements FavoriteService {
    @Resource
    private FavoriteBookMapper favoriteBookMapper;
    @Override
    public Result favoriteBook(FavoriteDTO fd) {
        if(fd.getIsClick()){
            favoriteBookMapper.insertFavoriteBook(fd);
            return new Result(CodeEnum.FAVORITE_ADD_SUCESS);
        }else {
            favoriteBookMapper.deleteFavoriteBook(fd);
            return new Result(CodeEnum.FAVORITE_DELETE_SUCESS);
        }
    }

    @Override
    public Result getFavoriteBook(Integer jobNumber) {
        List<AllFavoriteDTO> favoriteBook = favoriteBookMapper.getFavoriteBook(jobNumber);
        if(favoriteBook==null){
            return new Result(CodeEnum.FAVORITE_EMPTY);
        }
        return new Result(CodeEnum.FAVORITE_SUCESS,favoriteBook);
    }

    @Override
    public Result getLike(FavoriteDTO favoriteDTO) {
        try {
            Integer result= favoriteBookMapper.getAllIsbnByJobNumber(favoriteDTO);
            if(result == null){
                return new Result(CodeEnum.SELECT_SUCCESS,false);
            }else{
                return new Result(CodeEnum.SELECT_SUCCESS,true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new Result(CodeEnum.SELECT_FAILED);
    }
}

