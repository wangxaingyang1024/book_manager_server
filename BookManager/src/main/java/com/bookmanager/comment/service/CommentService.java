package com.bookmanager.comment.service;

import com.bookmanager.comment.dto.IsClickDTO;
import com.bookmanager.setting.model.Comment;
import com.bookmanager.setting.vo.Result;

public interface CommentService {
    Result addComment(Comment comment);
    Result updateComment(IsClickDTO clickDTO);
    Result findEnd(IsClickDTO isClickDTO);
    Result personalList(IsClickDTO personal);
    Result personalAdditionLike(IsClickDTO personal);
    Result personalDeleteLike(IsClickDTO personal);
}
