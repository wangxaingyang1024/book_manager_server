package com.bookmanager.book.controller;

import com.bookmanager.book.dto.PageHelperDTO;
import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result adminFindAll(@RequestParam(name = "name")String name,
                               @RequestParam(name = "pageNum")Integer pageNum,
                               @RequestParam(name = "pageSize")Integer pageSize){
        Result allBook = bookService.findAdminAllBook(name,pageNum,pageSize);
        return allBook;
    }

//    @GetMapping("/find/{pageNum}/{pageSize}")
//    public Result adminFindAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
//        Result allBook = bookService.findAdminAllBook(pageNum,pageSize);
//        return allBook;
//    }
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
    public Result  addBook(@RequestBody Book book){
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
    @PostMapping("/update")
    public Result updateBook(@RequestBody Book book){
        Result result = bookService.updateBook(book);
        return result;
    }
    /**
     * 类型列表获取
     * @return
     */
    @GetMapping("/type/{level}")
    public Result<List<String>> getBookTypeList(@PathVariable Integer level){
        return bookService.getListType(level);
    }

}
