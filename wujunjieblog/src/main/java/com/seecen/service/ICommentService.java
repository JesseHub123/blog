package com.seecen.service;

import com.seecen.model.Comment;

import java.util.List;

public interface ICommentService {
    Integer addComment(Comment comment);
    List<Comment> getCommentByBlogId(Integer blogId);
}
