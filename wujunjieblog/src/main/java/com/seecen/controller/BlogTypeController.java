package com.seecen.controller;

import com.seecen.model.Type;
import com.seecen.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 吴俊杰
 * @Data 2020/3/27 20:20
 * @Description
 */
@RestController
@RequestMapping("/blogType")
public class BlogTypeController {
    @Autowired
    IBlogTypeService blogTypeService;
    @PostMapping("/addType.do")
    public int addBlogType(@RequestBody Type type) {
        return blogTypeService.addBlogType(type);
    }
    @GetMapping("/getAllType.do")
    public List<Type> getAllType() {
        return blogTypeService.findAllType();
    }
}
