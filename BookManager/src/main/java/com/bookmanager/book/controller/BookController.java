package com.bookmanager.book.controller;

import com.bookmanager.book.dto.RelationBookEmpDTO;
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
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;
    /**
     * 查询所有图书
     * @return list
     */
    @GetMapping("/find")
    public Result userFindAll(){
        Result result = bookService.findAllBook();
        return Result.success(result);
    }

    /**
     * 用户查询自己的借书信息
     * @param jobNumber
     * @return
     */
    @GetMapping("/findOne/{jobNumber}")
    public  Result<List<Book>> userFindByEmpNumber(@PathVariable int jobNumber){
        return bookService.findByEmpNumber(jobNumber);
    }
    /**
     * 借书
     */
    @PostMapping("/borrow")
    public Result borrowBook(@RequestBody RelationBookEmpDTO rbed){
        bookService.borrowBook(rbed);
        return new Result(CodeEnum.BOOK_BORROW_SUCCESS);
    }
    /**
     * 还书
     */
    @PostMapping("/return")
    public Result returnBoook(@RequestBody RelationBookEmpDTO rbed){
        bookService.returnBook(rbed);
        return new Result(CodeEnum.BOOK_RETURN_SUCCESS);
    }

    @PostMapping("/likeName")
    public Result likeQuery(@RequestBody String name ){
        return bookService.selectLike(name);
    }
}
