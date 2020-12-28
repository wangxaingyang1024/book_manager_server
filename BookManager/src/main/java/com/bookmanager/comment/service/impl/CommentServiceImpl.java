package com.bookmanager.comment.service.impl;

import com.bookmanager.comment.dto.Comment;
import com.bookmanager.comment.dto.RComment;
import com.bookmanager.comment.mapper.CommentMapper;
import com.bookmanager.comment.service.CommentService;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    //添加评论
    @Override

    public Result addComment(Comment comment) {
        comment.setCommentTime(new Date());
        if(comment.getParNumber()==null) {
            comment.setParNumber(comment.getIsbn());
        }
        commentMapper.addComment(comment);
        return new Result(CodeEnum.COMMENT_ADD_SUCCESS);
    }

    //更新点赞
    @Override
    public Result updateComment(Comment comment) {
        comment.setLikeCount(comment.getLikeCount()+1);
        commentMapper.updateComment(comment);
        return new Result(CodeEnum.COMMENT_LIKE_SUCCESS);
    }

    @Override
    public Result findAllComment(int isbn) {
        Map<Comment,List<Comment>> map = new HashMap<>();
        List<Comment> myNumberComment = commentMapper.findAllComment(isbn);
        for (Comment comment : myNumberComment) {
            List<Comment> list = commentMapper.findSunComment(comment);
            map.put(comment,list);
        }
        System.out.println(map);
        return new Result(CodeEnum.COMMENT_Find_SUCCESS,map);
    }


    @Override
    public Result find(int isbn) {
        Map<RComment,List<RComment>> map = new HashMap<>();
        List<RComment> rComments = commentMapper.find(isbn);
        for (RComment rcomment : rComments) {
            rcomment.setPName(rcomment.getName());
            List<RComment> list = commentMapper.findSun(rcomment);
            for (RComment rComment : list) {
                rComment.setPName(commentMapper.findRSun(rComment));
            }
            map.put(rcomment,list);
        }
        System.out.println(map);
        return new Result(CodeEnum.COMMENT_Find_SUCCESS,map);
    }


    public Result findend(int isbn) {
        List<RComment> list = commentMapper.find(isbn);
        for (RComment rComment : list) {
            rComment.setPName(rComment.getName());
            rComment.setList(commentMapper.findSun(rComment));
            for (RComment comment : rComment.getList()) {
                comment.setPName(commentMapper.findRSun(comment));
            }
        }
        return new Result(CodeEnum.COMMENT_Find_SUCCESS,list);
    }
}
