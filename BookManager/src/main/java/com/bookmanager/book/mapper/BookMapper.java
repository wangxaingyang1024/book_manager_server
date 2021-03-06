package com.bookmanager.book.mapper;

import com.bookmanager.book.dto.BookListDTO;
import com.bookmanager.book.dto.BookTypeDTO;
import com.bookmanager.book.dto.RelationBookEmpDTO;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.model.BookExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {

    String selectNameByIsbn(Integer isbn);

    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer isbn);

    int insertSelective(Book record);

    List<String> selectTypeByType();

    List<Book> selectByExampleWithBLOBs(BookExample example);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Long id);

    List<Book> selectByType(Integer type);

    int insertBook(@Param("record") Book record);

    Book findBookByIsbn(long isbn);

    Book getBookIsbn(Integer lon);

    List<BookListDTO> selectLikeName(String name );

    int deleteBookByIsbn(Integer isbn);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExampleWithBLOBs(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKeyWithBLOBs(Book record);

    int updateByPrimaryKey(Book record);

    int updateBook(@Param("book") Book book);

    int borrowBookByIsbn(Integer isbn);

    int returnBookByIsbn(Integer isbn);

    List<BookListDTO > FindByEmpNumber(Integer jobNumber);

    int insertRelation(@Param("rbed") RelationBookEmpDTO rbed);

    int deleteLogByJobNumberAndIsbn(@Param("rbed") RelationBookEmpDTO rbed);

    int insertLog(@Param("rbed") RelationBookEmpDTO rbed);

    int updateReturnTime(@Param("rbed") RelationBookEmpDTO rbed);

    List<BookListDTO> findAdminAllBook();

}