package com.zjkj.bookmanager.service.impl;

import com.zjkj.bookmanager.mapper.BookMapper;
import com.zjkj.bookmanager.pojo.Book;
import com.zjkj.bookmanager.service.BookService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper ;


    @Override
    public int addBook(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public int deleteBook(Long id) {
        Book book = bookMapper.selectByPrimaryKey(id);
        if(book != null) {
            return bookMapper.deleteByPrimaryKey(id);
        }
        return -1 ;
    }

    @Override
    public int  update(Book book) {
        Book b = bookMapper.selectByPrimaryKey(book.getId());
        if(b != null) {
            return bookMapper.updateByPrimaryKey(book);
        }
        return -1;
    }

    @Override
    public Book selectBookByName(String name) {
        return bookMapper.selectByBookName(name);
    }

    @Override
    public Book selectBookByNumber(Long number) {
        return bookMapper.selectByBookNumber(number);
    }

    @Override
    public List<Book> selectBookByAuthor(String author) {
        return bookMapper.selectByAuthor(author);
    }

}
