package com.seecen.service;

import com.github.pagehelper.PageInfo;
import com.seecen.model.Blog;
import com.seecen.model.Type;

import java.util.List;

/**
 * @Author 吴俊杰
 * @Data 2020/3/27 20:06
 * @Description
 */
public interface IBlogTypeService {
    Integer addBlogType(Type type);
    List<Type> findAllType();
    Integer deleteBlogType(Integer blogTypeId);
    PageInfo<Type> getTypeByPage(Integer pageNum,Integer pageSize);
    Integer updateBlogType(Type type);
}
