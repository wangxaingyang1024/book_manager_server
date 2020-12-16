package com.bookmanager.book.service;

import com.bookmanager.book.dto.PageHelperDTO;
import com.bookmanager.book.dto.RelationBookEmpDTO;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BookService {

    Result querySort();
    /**
     * 管理员获取图书列表
     * @return
     */
    Result findAdminAllBook(String name ,Integer pageNum , Integer pageSize);
    /**
     * 录入新书
     * @param book
     * @return
     */
    Result addBook(Book book);

    /**
     * 删除图书
     * @param isbn
     * @return
     */
    Result deleteBookByIsbn(Long isbn);

    /**
     *
     * @param rbed
     * @return
     */
    Result borrowBook(RelationBookEmpDTO rbed);

    /**
     *
     * @param rbed
     * @return
     */
    Result  returnBook(RelationBookEmpDTO rbed);

    /**
     * 管理员修改图书
     * @param book
     * @return
     */
    Result updateBook(Book book);

    /**
     * 管理员查询某用户的借书情况
     * @return
     */
   Result findByEmpNumber(int jobNumber);

   Result getListType(Integer level);

}
