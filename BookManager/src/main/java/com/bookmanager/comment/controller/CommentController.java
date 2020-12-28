package com.bookmanager.comment.controller;

import com.bookmanager.comment.dto.Comment;
import com.bookmanager.comment.service.CommentService;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public Result addCommentSun(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return Result.success(CodeEnum.COMMENT_ADD_SUCCESS);
    }

    @PostMapping("/updateComment")
    public Result updateComment(@RequestBody Comment comment) {
        commentService.updateComment(comment);
        return Result.success(CodeEnum.COMMENT_LIKE_SUCCESS);
    }

    @GetMapping("/findAllComment/{isbn}")
    public Result findAllComment(@PathVariable("isbn") int isbn) {
        Result myNumberComment = commentService.findAllComment(isbn);
        return Result.success(myNumberComment);
    }

    @GetMapping("/find/{isbn}")
    public Result find(@PathVariable("isbn") int isbn) {
        Result myNumberComment = commentService.find(isbn);
        return Result.success(myNumberComment);
    }

    @GetMapping("/findend/{isbn}")
    public Result findend(@PathVariable("isbn") int isbn) {
        Result myNumberComment = commentService.findend(isbn);
        return Result.success(myNumberComment);
    }

}
