package com.seecen.controller;

import com.github.pagehelper.PageInfo;
import com.seecen.model.Blog;
import com.seecen.model.Comment;
import com.seecen.service.IBlogService;
import com.seecen.service.impl.BlogTypeServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author 吴俊杰
 * @Data 2020/3/27 21:40
 * @Description
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @PostMapping("/addBlog.do")
    public Integer addBlog(@RequestBody Blog blog) {
        System.err.println("博客内容为:"+blog.getBlogContent());
        return blogService.addBlog(blog);
    }
    @PostMapping(value = "/getImage.do",produces = "text/html;charset=UTF-8")
    public String getImage(MultipartFile blogImage, HttpServletRequest request) {
        return blogService.addImage(blogImage,request);
    }
    @PostMapping("/deleteImg.do")
    public Integer deleteImags(String imgUrl,HttpServletRequest request) {
        System.out.println("图片路径为:"+imgUrl);
        return blogService.deleteImage(imgUrl,request);
    }
    @GetMapping("/getBlogById.do")
    public Blog getBlogById(Integer blogId) {
        return blogService.getBlogById(blogId);
    }
    @GetMapping("/getRanBlog.do")
    public List<Blog> GetRanBlog() {
        return blogService.selectRandom();
    }
    @GetMapping("/getNewest.do")
    public List<Blog> GetNewest() {
        return blogService.selectNewest();
    }
    @GetMapping("/getLastOneBlog.do")
    public Blog getLastOneBlog(Integer blogId) {
        return blogService.selectLastOneBlog(blogId);
    }
    @GetMapping("/getNextOneBlog.do")
    public Blog getNextOneBlog(Integer blogId) {
        return blogService.selectNextOneBlog(blogId);
    }
    @GetMapping("/getBlogByType.do")
    public List<Blog> getBlogByType() {
        return blogService.selectBlogByType();
    }
    @GetMapping("/getAllBlogByType.do")
    public PageInfo<Blog> getAllBlogByType(String typeContent,Integer pageNum,Integer pageSize) {
        return blogService.selectAllByBlogType(typeContent,pageNum,pageSize);
    }
    @GetMapping("/updateComments.do")
    public Integer updateBlogCommentsByBlogId(Integer blogId) {
        return blogService.updateBlogCommentsByBlogId(blogId);
    }
    @GetMapping("/updateView.do")
    public Integer updateBlogViewByBlogId(Integer blogId){
        return blogService.updateBlogViewByBlogId(blogId);
    }
    @GetMapping("/getAllBlogSign.do")
    public List<Blog> selectAllBlogSign() {
        return blogService.selectAllBlogSign();
    }
    @GetMapping("/getAllByBlogSign.do")
    public PageInfo<Blog> getAllByBlogSign(String typeContent,Integer pageNum,Integer pageSize){
        return blogService.selectAllByBlogSign(typeContent,pageNum,pageSize);
    }
    @GetMapping("/getAllBlog.do")
    public PageInfo<Blog> getAllBlog(Integer pageNum,Integer pageSize) {
        return blogService.selectAll(pageNum,pageSize);
    }
    @GetMapping("/selectBlogsByTip.do")
    public List<Blog> selectLikeByTitle(String tip) {
        return  blogService.selectLikeByTitle(tip);
    }

}
