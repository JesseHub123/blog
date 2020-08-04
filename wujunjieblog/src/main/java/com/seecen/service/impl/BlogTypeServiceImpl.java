package com.seecen.service.impl;

import com.github.pagehelper.PageInfo;
import com.seecen.dao.ITypeDao;
import com.seecen.model.Type;
import com.seecen.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 吴俊杰
 * @Data 2020/3/27 20:07
 * @Description
 */
@Service
public class BlogTypeServiceImpl implements IBlogTypeService {
    @Autowired
    ITypeDao iTypeDao;

    @Transactional
    public Integer addBlogType(Type type) {
        //如果type值为空 则返回添加失败信号
        if (type.getTypeContent().equals("")){
            return -1;
        }
        return iTypeDao.insert(type);
    }

    @Override
    public List<Type> findAllType() {
        return iTypeDao.selectAll();
    }


    public Integer deleteBlogType(Integer blogTypeId) {
        return null;
    }


    public PageInfo<Type> getTypeByPage(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Integer updateBlogType(Type type) {
        return null;
    }
}
