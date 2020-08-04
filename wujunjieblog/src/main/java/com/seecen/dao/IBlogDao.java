package com.seecen.dao;

import com.seecen.model.Blog;
import com.seecen.model.Comment;

import java.util.List;

public interface IBlogDao {
    int deleteByPrimaryKey(Integer blogId);

    int insert(Blog record);

    Blog selectByPrimaryKey(Integer blogId);

    List<Blog> selectAll();

    int updateByPrimaryKey(Blog record);
    List<Blog> selectRandom();
    List<Blog> selectNewest();
    Blog selectLastOneBlog(Integer blogId);
    Blog selectNextOneBlog(Integer blogId);
    List<Blog> selectBlogByType();
    List<Blog> selectAllByBlogType(String typeContent);
    Integer updateBlogCommentsByBlogId(Integer blogId);
    Integer updateBlogViewByBlogId(Integer blogId);
    List<Blog> selectAllBlogSign();
    List<Blog> selectAllByBlogSign(String blogSign);
    List<Blog> selectLikeByTitle(String tips);
}