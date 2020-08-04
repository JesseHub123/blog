package com.seecen.dao;

import com.seecen.model.Comment;
import java.util.List;

public interface ICommentDao {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByBlogId(Integer blogId);
    //获得每个博客的评论总数
    Integer selectCountByBlogId(Integer blogId);

}