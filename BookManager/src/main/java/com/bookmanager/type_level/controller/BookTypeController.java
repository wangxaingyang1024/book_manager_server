package com.bookmanager.type_level.controller;

import com.bookmanager.setting.model.BookTypeLevel;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.type_level.dto.BookTypeLevelDTO;
import com.bookmanager.type_level.service.IBookTypeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/bookType/")
public class BookTypeController {

    @Autowired
    private IBookTypeLevelService levelService ;

    @PostMapping("add")
    public Result insertType(@RequestBody BookTypeLevel bookTypeLevel){
        return levelService.addBookType(bookTypeLevel) ;
    }
}
