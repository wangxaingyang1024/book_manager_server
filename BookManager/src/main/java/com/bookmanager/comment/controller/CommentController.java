package com.bookmanager.comment.controller;

import com.bookmanager.comment.dto.IsClickDTO;
import com.bookmanager.setting.model.Comment;
import com.bookmanager.comment.service.CommentService;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public Result addCommentSun(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PostMapping("/updateComment")
    public Result updateComment(@RequestBody IsClickDTO clickDTO) {
       return  commentService.updateComment(clickDTO);
    }

    @PostMapping("/findEnd")
    public Result findEnd(@RequestBody IsClickDTO isClickDTO) {
        return  commentService.findEnd(isClickDTO);
    }

    @PostMapping("/personalLike")
    public Result personalLike(@RequestBody IsClickDTO personal){
        return commentService.personalList(personal);
    }
}