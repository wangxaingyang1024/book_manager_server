package com.zjkj.bookmanager.mapper;

import com.zjkj.bookmanager.pojo.InfoRecord;
import com.zjkj.bookmanager.pojo.InfoRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface InfoRecordMapper {
    long countByExample(InfoRecordExample example);

    int deleteByExample(InfoRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InfoRecord record);

    int insertSelective(InfoRecord record);

    List<InfoRecord> selectByExample(InfoRecordExample example);

    InfoRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InfoRecord record, @Param("example") InfoRecordExample example);

    int updateByExample(@Param("record") InfoRecord record, @Param("example") InfoRecordExample example);

    int updateByPrimaryKeySelective(InfoRecord record);

    int updateByPrimaryKey(InfoRecord record);
}