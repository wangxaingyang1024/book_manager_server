package com.bookmanager.favorite.controller;

import com.bookmanager.favorite.dto.FavoriteDTO;
import com.bookmanager.favorite.service.FavoriteService;
import com.bookmanager.setting.token.UserLoginToken;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class FavoriteBookController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/favorite")
    public Result favoriteBook(@RequestBody FavoriteDTO fd){
        return  favoriteService.favoriteBook(fd);
    }


    @GetMapping("/getFavorite/{jobNumber}")
    public Result getFavoriteBook(@PathVariable Integer jobNumber){
        return favoriteService.getFavoriteBook(jobNumber);
    }
}
