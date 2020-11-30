package com.bookmanager.book.controller;

import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookAdminController {
    @Autowired
    private BookService bookService ;
    @GetMapping("/book/{id}")
    public Result getBook(@PathVariable Long id){
        Book book = bookService.getBook(id);
        return Result.success();
    }

}
