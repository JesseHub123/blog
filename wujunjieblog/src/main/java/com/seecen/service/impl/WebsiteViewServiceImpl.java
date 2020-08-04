package com.seecen.service.impl;

import com.seecen.dao.WebsiteViewDao;
import com.seecen.model.WebsiteView;
import com.seecen.service.IWebsiteViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 吴俊杰
 * @Data 2020/4/11 20:16
 * @Description
 */
@Service
public class WebsiteViewServiceImpl implements IWebsiteViewService {
    @Autowired
    private WebsiteViewDao websiteViewDao;
    @Override
    public Integer updateByPrimaryKey() {
        int rows = websiteViewDao.updateByPrimaryKey();
        if (rows == 1) {
            return websiteViewDao.selectByPrimaryKey().getwCount();
        }
        return -1;
    }

}
