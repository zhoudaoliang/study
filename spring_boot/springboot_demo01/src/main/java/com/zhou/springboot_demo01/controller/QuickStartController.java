package com.zhou.springboot_demo01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class QuickStartController {
    @RequestMapping("/quick")
    public String quick(){
        return "springboot 访问成功";
    }
}
