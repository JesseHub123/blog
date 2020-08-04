package com.seecen.controller;

import com.seecen.model.Comment;
import com.seecen.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 吴俊杰
 * @Data 2020/4/3 18:47
 * @Description
 */
@RestController
@RequestMapping("/comment")
public class BlogCommentController {
    @Autowired
    ICommentService commentService;
    @PostMapping("/addComment.do")
    public Integer addComment(Comment comment) {
        System.out.println(comment);
        return commentService.addComment(comment);

    }
    @GetMapping("/getByBlogId.do")
    public List<Comment> getCommentByBlogId(Integer blogId) {
        return commentService.getCommentByBlogId(blogId);
    }

}
