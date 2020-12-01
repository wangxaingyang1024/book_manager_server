package com.bookmanager.book.controller;

import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BookAdminController {
    @Autowired
    private BookService bookService ;
    @GetMapping("/book/{id}")
    public Result getBook(@PathVariable Long id){
        Book book = bookService.getBook(id);
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
        int boo = bookService.addBook(book);
        return new Result(CodeEnum.BOOK_ADD_SUCCESS);
    }

    /**
     * 删除图书
     * @param isbn
     * @return
     */
    @RequestMapping("/delete/{isbn}")
    public Result deleteBook(@PathVariable Long isbn){
        int book = bookService.deleteBookByIsbn(isbn);
        return new Result(CodeEnum.BOOK_DELETE_SUCCESS);
    }

    /**
     * 更新图书
     * @return
     */
    @RequestMapping("/update/{isbn}")
    public Result updateBook(@PathVariable Long isbn){
        Result result = bookService.updateBook(isbn);
        return result;
    }
}
