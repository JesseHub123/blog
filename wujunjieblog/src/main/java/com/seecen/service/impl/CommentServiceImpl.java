package com.seecen.service.impl;

import com.seecen.dao.IBlogDao;
import com.seecen.dao.ICommentDao;
import com.seecen.model.Comment;
import com.seecen.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author 吴俊杰
 * @Data 2020/4/3 18:46
 * @Description
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentDao commentDao;
    @Autowired
    IBlogDao blogDao;
    @Transactional
    public Integer addComment(Comment comment) {
        //1为评论可以正常发布
        comment.setCommentState(1);
        //评论发布时间
        Timestamp createTime = new Timestamp(new Date().getTime());
        comment.setCommentTime(createTime);
        int rows=0;
        try {
             rows = commentDao.insert(comment);
        }catch (Exception e) {
            e.printStackTrace();
            return rows;
        }
        blogDao.updateBlogCommentsByBlogId(comment.getBlogId());

        return rows;
    }

    @Transactional(readOnly = true)
    public List<Comment> getCommentByBlogId(Integer blogId) {
        return commentDao.selectByBlogId(blogId);
    }


}
