package com.bookmanager.type_level.controller;

import com.bookmanager.setting.model.BookTypeLevel;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.type_level.dto.BookTypeLevelDTO;
import com.bookmanager.type_level.service.IBookTypeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/bookType/")
public class BookTypeController {

    @Autowired
    private IBookTypeLevelService levelService ;

    /**
     * 添加图书类型
     * @param bookTypeLevel
     * @return
     */
    @PutMapping("add")
    public Result insertType(@RequestBody BookTypeLevel bookTypeLevel){
        return levelService.addBookType(bookTypeLevel) ;
    }

//    public Result removeType()
}
