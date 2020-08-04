package com.seecen.service;

import com.seecen.model.User;

public interface IUserService {
    Integer doLogin(String username,String password);
}
