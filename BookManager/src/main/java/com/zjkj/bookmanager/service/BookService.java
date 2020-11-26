package com.zjkj.bookmanager.service;

import com.zjkj.bookmanager.mapper.BookMapper;
import com.zjkj.bookmanager.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    int addBook(Book book);

    int deleteBook(Long id );

    int update( Book book);

    Book selectBookByName(String name);

    Book selectBookByNumber(Long number);

    List<Book> selectBookByAuthor(String Author);

}
