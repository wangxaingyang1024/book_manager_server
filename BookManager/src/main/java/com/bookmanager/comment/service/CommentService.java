package com.bookmanager.comment.service;

import com.bookmanager.comment.dto.Comment;
import com.bookmanager.setting.vo.Result;

public interface CommentService {
    Result addComment(Comment comment);
    Result updateComment(Comment comment);
    Result findAllComment(int isbn);
    Result find(int isbn);
    Result find11(int isbn);
}
