package com.bookmanager.book.controller;

import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BookAdminController {
    @Autowired
    private BookService bookService ;
    @GetMapping("/book/{isbn}")
    public Result getBook(@PathVariable Long isbn){
        Book book = bookService.getBook(isbn);
        return Result.success();
    }
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
     * 添加图书
     * @param book
     * @return
     */
    @RequestMapping("/add")
    public Result  addBook(Book book){
        bookService.addBook(book);
        return new Result(CodeEnum.BOOK_ADD_SUCCESS);
    }

    /**
     * 删除图书
     * @param isbn
     * @return
     */
    @RequestMapping("/delete/{isbn}")
    public Result deleteBook(@PathVariable Long isbn){
        bookService.deleteBookByIsbn(isbn);
        return new Result(CodeEnum.BOOK_DELETE_SUCCESS);
    }

    /**
     * 更新图书
     * @return
     */
    @RequestMapping("/update/{isbn}")
    public Result updateBook(@PathVariable Long isbn){
        bookService.updateBook(isbn);
        return new Result(CodeEnum.BOOK_UPDATE_SUCCESS);
    }
}
