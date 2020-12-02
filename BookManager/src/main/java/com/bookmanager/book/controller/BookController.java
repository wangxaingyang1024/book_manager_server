package com.bookmanager.book.controller;

import com.bookmanager.book.service.BookService;
import com.bookmanager.book.service.impl.BookServiceImpl;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class BookController {
    @Autowired
    private BookService bookService;
    /**
     * 查询所有图书
     * @return list
     */
    @GetMapping("/find")
    public Result findAll(){
        List<Book> list = bookService.findAll();
        return Result.success(list);
    }

    /**
     * 借书
     */
    @RequestMapping("/borrow/{isbn}")
    public Result borrowBook(@PathVariable long isbn){
        bookService.borrowBook(isbn);
        return new Result(CodeEnum.BOOK_BORROW_SUCCESS);
    }
    /**
     * 还书
     */
    @RequestMapping("/return/{isbn}")
    public Result returnBoook(@PathVariable Long isbn){
        bookService.returnBook(isbn);
        return new Result(CodeEnum.BOOK_RETURN_SUCCESS);
    }
}
