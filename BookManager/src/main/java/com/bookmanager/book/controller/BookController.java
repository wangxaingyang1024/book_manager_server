package com.bookmanager.book.controller;

import com.bookmanager.book.service.BookService;
import com.bookmanager.book.service.impl.BookServiceImpl;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    /**
     * 查询所有图书
     * @return
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
    @RequestMapping("/insert")
    public String  addBook(Book book){
        //随机生成isbn
//
//        Book book1 = bookService.getBook(isbn);
//        if(book1 != null){
//            addBook(book);
//        }
        int boo = bookService.addBook(book);
        return boo>0?"添加图书成功。":"添加图书失败！";
    }
    /**
     * 删除图书
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public int deleteBook(@PathVariable Long id){
        int book = bookService.deleteBook(id);
        return book;
    }
    /**
     * 借书
     */
}
