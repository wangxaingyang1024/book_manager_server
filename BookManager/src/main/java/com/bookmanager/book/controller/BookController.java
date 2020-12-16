package com.bookmanager.book.controller;

import com.bookmanager.book.dto.BookTypeDTO;
import com.bookmanager.book.dto.PageHelperDTO;
import com.bookmanager.book.dto.RelationBookEmpDTO;
import com.bookmanager.book.service.BookService;
import com.bookmanager.book.service.impl.BookServiceImpl;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.token.UserLoginToken;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;
    /**
     * 用户查询自己的借书信息
     * @param jobNumber
     * @return
     */
    @UserLoginToken
    @GetMapping("/findOne/{jobNumber}")
    public  Result<List<Book>> userFindByEmpNumber(@PathVariable int jobNumber){
        return bookService.findByEmpNumber(jobNumber);
    }
    /**
     * 借书
     */
    @UserLoginToken
    @PostMapping("/borrow")
    public Result borrowBook(@RequestBody RelationBookEmpDTO rbed){
        bookService.borrowBook(rbed);
        return new Result(CodeEnum.BOOK_BORROW_SUCCESS);
    }
    /**
     * 还书
     */
    @UserLoginToken
    @PostMapping("/return")
    public Result returnBoook(@RequestBody RelationBookEmpDTO rbed){
        bookService.returnBook(rbed);
        return new Result(CodeEnum.BOOK_RETURN_SUCCESS);
    }

    /**
     * 分类标签
     * @return
     */
    @GetMapping("/sort")
    public Result sortBook(){
        return bookService.querySort();
    }


}
