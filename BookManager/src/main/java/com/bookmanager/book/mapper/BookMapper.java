package com.bookmanager.book.mapper;

import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.model.BookExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Long isbn);

    int insertSelective(Book record);

    List<Book> selectByExampleWithBLOBs(BookExample example);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Long id);

<<<<<<< HEAD
    List<Book> findAllBook();

    int insertBook(Book record);

    Book findBookByIsbn(long isbn);

    Book getBookIsbn(Long lon);

    int deleteBookByIsbn(Long isbn);
=======
    List<Book> findAll();

    int deleteBook(Long id);
>>>>>>> origin/master

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExampleWithBLOBs(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKeyWithBLOBs(Book record);

    int updateByPrimaryKey(Book record);


}