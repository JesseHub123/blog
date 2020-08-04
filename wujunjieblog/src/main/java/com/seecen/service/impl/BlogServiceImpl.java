package com.seecen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seecen.dao.IBlogDao;
import com.seecen.model.Blog;
import com.seecen.model.Comment;
import com.seecen.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author 吴俊杰
 * @Data 2020/3/27 20:07
 * @Description
 */
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogDao blogDao;
    @Transactional
    public Integer addBlog(Blog blog) {
        String author = "Jesse";
        blog.setBlogAuthor(author);
        Timestamp createTime = new Timestamp(new Date().getTime());
        blog.setBlogCreatetime(createTime);
        blog.setBlogView(0);
        return blogDao.insert(blog);
    }
    @Transactional
    public String addImage(MultipartFile blogImage, HttpServletRequest request) {
        // 保存图片的路径，图片上传成功后，将路径返回给前台
        String path=request.getSession().getServletContext().getRealPath("upload/");
//        String path = "/home/webDemo/tomcat/apache-tomcat-8.0.23/webapps/wujunjieblog/upload";
        System.err.println("path:"+path);
        // 获取原始图片的扩展名
        String originalFilename = blogImage.getOriginalFilename();
        // 生成文件新的名字
        String newFileName = UUID.randomUUID() + originalFilename;
        // 封装上传文件位置的全路径
        File targetFile = new File(path, newFileName);
        try {
            blogImage.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println("图片要返回的路径:"+newFileName);
//        /home/webDemo/tomcat/apache-tomcat-8.0.23/webapps/wujunjieblog/upload

        return newFileName;
    }

   @Transactional
    public Integer deleteImage(String imgUrl,HttpServletRequest request) {
        // 保存图片的路径，图片上传成功后，将路径保存到数据库
        String path1=request.getSession().getServletContext().getRealPath("upload/");
        System.out.println("upload路径:"+path1);
        String temp[];
        temp=imgUrl.split("&");
        for (String s : temp) {
            System.out.println("删除图片开始");
            String path = path1+s;
            System.out.println("开始执行，图片路径为"+path);
            File file = new File(path);
            //判断文件是否存在
            if (file.exists() == true){
                System.out.println("图片存在，可执行删除操作");
                Boolean flag = false;
                flag = file.delete();
                if (flag){
                    System.out.println("成功删除图片"+file.getName());
                }else {
                    System.out.println("删除失败");
                }
            }else {
                System.out.println("图片不存在，终止操作");
            }
        }


        return 1;
    }



    public Blog getBlogById(Integer blogId) {
        return blogDao.selectByPrimaryKey(blogId);
    }


    public List<Blog> selectRandom() {
        return blogDao.selectRandom();
    }


    public List<Blog> selectNewest() {
        return blogDao.selectNewest();
    }


    public Blog selectLastOneBlog(Integer blogId) {
        return blogDao.selectLastOneBlog(blogId);
    }


    public Blog selectNextOneBlog(Integer blogId) {
        return blogDao.selectNextOneBlog(blogId);
    }


    public List<Blog> selectBlogByType() {
        return blogDao.selectBlogByType();
    }


    public PageInfo<Blog> selectAllByBlogType(String typeContent, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogs = blogDao.selectAllByBlogType(typeContent);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo ;
    }

    @Transactional
    public Integer updateBlogCommentsByBlogId(Integer blogId) {
        return blogDao.updateBlogCommentsByBlogId(blogId);
    }

    @Transactional
    public Integer updateBlogViewByBlogId(Integer blogId) {
        return blogDao.updateBlogViewByBlogId(blogId);
    }

    @Override
    public List<Blog> selectAllBlogSign() {
        return blogDao.selectAllBlogSign();
    }

    @Override
    public PageInfo<Blog> selectAllByBlogSign(String blogSign,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogs = blogDao.selectAllByBlogSign(blogSign);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public PageInfo<Blog> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogs = blogDao.selectAll();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public List<Blog> selectLikeByTitle(String tips) {
        List<Blog> blogs = blogDao.selectLikeByTitle(tips);
        return blogs;
    }
}
