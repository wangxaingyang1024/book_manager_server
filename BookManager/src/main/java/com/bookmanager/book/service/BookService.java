package com.bookmanager.book.service;

import com.bookmanager.setting.model.Book;

import java.util.List;

public interface BookService {

    Book getBook(Long id);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> findAll();

    /**
     * 借书
     * @param isbn
     * @return
     */
    int borrowBook(Long isbn);

    /**
     *还书
     * @param isbn
     * @return
     */
    int  returnBook(Long isbn);

    /**
     * 录入新书
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 删除图书
     * @param id
     * @return
     */
    int deleteBook(long id);
}
