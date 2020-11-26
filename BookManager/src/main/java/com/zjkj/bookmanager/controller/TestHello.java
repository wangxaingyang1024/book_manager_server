package com.zjkj.bookmanager.controller;

import com.zjkj.bookmanager.pojo.Book;
import com.zjkj.bookmanager.service.BookService;
import com.zjkj.bookmanager.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestHello {

    @Autowired
    private BookService bookService ;
    @ResponseBody
    @GetMapping("/hello")
    public Result<Book> helloTest(){
        Book book = bookService.selectBookByNumber(12345L);
        System.out.println(book);
        return Result.success(book);
    }
}
