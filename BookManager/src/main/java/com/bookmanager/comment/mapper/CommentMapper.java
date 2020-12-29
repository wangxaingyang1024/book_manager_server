package com.bookmanager.comment.mapper;

import com.bookmanager.comment.dto.IsClickDTO;
import com.bookmanager.setting.model.Comment;
import com.bookmanager.comment.dto.RComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    Integer removePersonalLike(@Param("personal") IsClickDTO personal);

    Integer insertPersonalLike(@Param("per") IsClickDTO personalLikeDTO);

    List<String> selectLikeByJobNumberAndIsbn(@Param("personal") IsClickDTO personal);

    Integer getCommentByMyFlag(String myFlag);

    List<RComment> selectByParFlag(String ParFlag);

    List<RComment> getCommentByParFlag(@Param("pFlag") String parFlag,@Param("isbn") Integer isbn);

    String findMFlagByIsExist(String mFlag);

    int addComment(@Param("comment") Comment comment);

    int updateComment(@Param("clickDTO") IsClickDTO clickDTO);
}
