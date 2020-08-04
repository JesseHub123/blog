package com.seecen.service;

import com.github.pagehelper.PageInfo;
import com.seecen.model.Blog;
import com.seecen.model.Comment;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IBlogService {
    Integer addBlog(Blog blog);
    String addImage(MultipartFile blogImage, HttpServletRequest request);
    Integer deleteImage(String imgUrl,HttpServletRequest request);
    Blog getBlogById(Integer blogId);
    List<Blog> selectRandom();
    List<Blog> selectNewest();
   Blog selectLastOneBlog(Integer blogId);
   Blog selectNextOneBlog(Integer blogId);
   List<Blog> selectBlogByType();
   PageInfo<Blog> selectAllByBlogType(String typeContent,Integer pageNum,Integer pageSize);
    Integer updateBlogCommentsByBlogId(Integer blogId);
    Integer updateBlogViewByBlogId(Integer blogId);
    List<Blog> selectAllBlogSign();
    PageInfo<Blog> selectAllByBlogSign(String blogSign,Integer pageNum,Integer pageSize);
    PageInfo<Blog> selectAll(Integer pageNum,Integer pageSize);
    List<Blog> selectLikeByTitle(String tips);

}
