package com.seecen.controller;

import com.seecen.service.IWebsiteViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 吴俊杰
 * @Data 2020/4/11 20:20
 * @Description
 */
@RestController
@RequestMapping("/website")
public class WebsiteViewController {
    @Autowired
    private IWebsiteViewService websiteViewService;
    @PostMapping("/addAndGet.do")
    public Integer updateAndSelect () {
        return websiteViewService.updateByPrimaryKey();
    }
}
