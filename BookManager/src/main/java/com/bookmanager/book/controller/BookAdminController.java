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
@RequestMapping("/api/admin")
public class BookAdminController {

    @Autowired
    private BookService bookService ;

    /**
     * 查询所有图书
     * @return list
     */
    @GetMapping("/find")
    public Result adminFindAll(){
        Result allBook = bookService.findAdminAllBook();
        return allBook;
    }
    /**
     * 管理员查询某个用户借书信息
     * @param jobNumber
     * @return
     */
    @GetMapping("/findOne/{jobNumber}")
    public  Result userFindByEmpNumber(@PathVariable int jobNumber){
        return bookService.findByEmpNumber(jobNumber);
    }
    /**
     * 添加图书
     * @param book
     * @return
     */
    @PostMapping("/add")
    public Result  addBook(Book book){
        return bookService.addBook(book);
    }

    /**
     * 删除图书
     * @param isbn
     * @return
     */
    @PostMapping("/delete/{isbn}")
    public Result deleteBook(@PathVariable Long isbn){
        return bookService.deleteBookByIsbn(isbn);
    }

    /**
     * 更新图书
     * @return
     */
    @PostMapping("/update/{isbn}")
    public Result updateBook(@PathVariable Book book){
        Result result = bookService.updateBook(book);
        return result;
    }

    /**
     * 类型列表获取
     * @return
     */
    @GetMapping("/type")
    public Result<List<String>> getBookTypeList(){
        return bookService.getListType();
    }
}
