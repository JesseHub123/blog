package com.seecen.service.impl;

import com.seecen.dao.ISubscribeDao;
import com.seecen.model.Subscribe;
import com.seecen.service.ISubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author 吴俊杰
 * @Data 2020/4/9 20:26
 * @Description
 */
@Service
public class SubsribeServiceImpl implements ISubscribeService {
    @Autowired
    private ISubscribeDao subscribeDao;
    @Transactional
    public Integer addSubscribe(Subscribe subscribe) {
        //评论发布时间
        Timestamp createTime = new Timestamp(new Date().getTime());
        subscribe.setSTime(createTime);
        int rows = 0;
        try {
            rows = subscribeDao.insert(subscribe);

        }catch (Exception e){
            e.printStackTrace();
            return rows;
        }
        return rows ;
    }
}
