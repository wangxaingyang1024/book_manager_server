package com.bookmanager.book.service.impl;

import com.bookmanager.book.mapper.BookMapper;
import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper ;

    @Override
    public Book getBook(Long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public int borrowBook(Long isbn) {
        return 0;
    }

    @Override
    public int  returnBook(Long isbn) {

        return 0;
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public int deleteBook(long isbn) {
        return bookMapper.deleteByPrimaryKey(isbn);
    }
}
