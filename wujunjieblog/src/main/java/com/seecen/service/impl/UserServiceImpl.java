package com.seecen.service.impl;

import com.seecen.dao.IUserDao;
import com.seecen.model.User;
import com.seecen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 吴俊杰
 * @Data 2020/4/11 17:11
 * @Description
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public Integer doLogin(String username,String password) {
        User user = userDao.doLogin(username,password);
        try {
            String password1 = user.getPassword();

        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return 1;
    }
}
