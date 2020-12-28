package com.bookmanager.type_level.controller;

import com.bookmanager.setting.model.BookTypeLevel;
import com.bookmanager.setting.token.UserLoginToken;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.type_level.dto.BookTypeLevelDTO;
import com.bookmanager.type_level.service.IBookTypeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    @UserLoginToken
    @PutMapping("add")
    public Result insertType(@RequestBody BookTypeLevel bookTypeLevel){
        return levelService.addBookType(bookTypeLevel) ;
    }
    @UserLoginToken
    @PostMapping("remove")
    public Result removeType(@RequestBody BookTypeLevelDTO levelDTO){
        Result result = levelService.deleteBookType(levelDTO);
        return result ;
    }
}
