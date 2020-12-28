package com.bookmanager.type_level.mapper;

import com.bookmanager.book.dto.BookTypeDTO;
import com.bookmanager.setting.model.BookTypeLevel;
import com.bookmanager.setting.model.BookTypeLevelExample;
import java.util.List;

import com.bookmanager.type_level.dto.BookTypeLevelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookTypeLevelMapper {
    long countByExample(BookTypeLevelExample example);

    int deleteByExample(BookTypeLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(@Param("record") BookTypeLevel record);

    int insertSelective(BookTypeLevel record);

    List<Integer> selectMidBypid(Integer pid);

    BookTypeLevelDTO selectBookTypeDTOByMid(Integer mid);

    List<BookTypeLevel> selectByExample(BookTypeLevelExample example);

    List<BookTypeDTO> selectBookByLevel(Integer level) ;

    List<BookTypeDTO> selectBookTypeByPid(Integer pid);

    BookTypeLevel selectBookTypeByMid(Integer mid);

    int deleteByMid(Integer mid) ;

    Integer selectPidByMid(Integer level);

    BookTypeLevel selectByPrimaryKey(Integer id);

    String selectByName(String name);

    Integer selectMidByMid(Integer mid);

    int updateByExampleSelective(@Param("record") BookTypeLevel record, @Param("example") BookTypeLevelExample example);

    int updateByExample(@Param("record") BookTypeLevel record, @Param("example") BookTypeLevelExample example);

    int updateByPrimaryKeySelective(BookTypeLevel record);

    int updateByPrimaryKey(BookTypeLevel record);
}