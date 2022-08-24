package com.zhou.springboot_demo02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/save")
    public String save(){
        return "save";
    }
}
