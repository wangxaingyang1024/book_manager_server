package com.bookmanager.comment.mapper;

import com.bookmanager.comment.dto.Comment;
import com.bookmanager.comment.dto.RComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    int addComment(@Param("comment") Comment comment);
    int updateComment(@Param("comment")Comment comment);
    List<Comment> findAllComment(int isbn);
    List<Comment> findSunComment(@Param("comment")Comment comment);
    List<RComment> find(int isbn);
    List<RComment> findSun(@Param("comment")RComment rcomment);
    String findRSun(@Param("comment")RComment rcomment);
}
