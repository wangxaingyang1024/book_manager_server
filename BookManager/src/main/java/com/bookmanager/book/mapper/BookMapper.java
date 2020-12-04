package com.bookmanager.book.mapper;

import com.bookmanager.book.dto.RelationBookEmpDTO;
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

    List<Book> userFindAllBook();

    List<Book> adminFindAllBook();

    int insertBook(Book record);

    Book findBookByIsbn(long isbn);

    Book getBookIsbn(Long lon);

    int deleteBookByIsbn(Long isbn);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExampleWithBLOBs(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKeyWithBLOBs(Book record);

    int updateByPrimaryKey(Book record);

    int updateBook(Book book);

    int borrowBookByIsbn(Long isbn);

    int returnBookByIsbn(Long isbn);

    List<Book> FindByEmpNumber(Integer jobNumber);

    int insertLog(@Param("rbed") RelationBookEmpDTO rbed);

    int deleteLogByJobNumberAndIsbn(@Param("rbed") RelationBookEmpDTO rbed);

}