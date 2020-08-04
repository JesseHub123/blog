package com.seecen.controller;

import com.seecen.model.Subscribe;
import com.seecen.service.ISubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 吴俊杰
 * @Data 2020/4/9 20:29
 * @Description
 */
@RestController
@RequestMapping("/subscribe")
public class BlogSubscribeController {
    @Autowired
    ISubscribeService subscribeService;
    @PostMapping("/add.do")
    public Integer addSubscribe(Subscribe subscribe) {
        return subscribeService.addSubscribe(subscribe);
    }
}
