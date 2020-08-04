package com.seecen.controller;

import com.seecen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 吴俊杰
 * @Data 2020/4/10 21:46
 * @Description
 */
@Controller
@RequestMapping("/user")
public class BlogUserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/login.do")
    public ModelAndView login(String username,String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        int rows = userService.doLogin(username,password);
        if (rows==1) {
            return modelAndView;
        }
       return new ModelAndView("error");
    }
    @RequestMapping("/blog_edit.do")
    public ModelAndView blog_edit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/blog_edit");
        return modelAndView;
    }
    @RequestMapping("/type_edit.do")
    public ModelAndView type_edit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/type_edit");
        return modelAndView;
    }
}
