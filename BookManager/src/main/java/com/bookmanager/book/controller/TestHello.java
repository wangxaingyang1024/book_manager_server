package com.bookmanager.book.controller;

import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestHello {

    @Autowired
    private BookService bookService ;
    @ResponseBody
    @GetMapping("/hello")
    public Result<Book> helloTest(){
        Book book = bookService.getBook(1l);
        log.info("这是书的信息：" + book);
        return Result.success(book);
    }
}
