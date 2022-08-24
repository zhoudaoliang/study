package com.zhou.controller;

import com.zhou.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    /***
     * 提供服务
     * @return
     */
    @RequestMapping("/list")
    public List<User> list(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("王五", "深圳", 25));
        users.add(new User("李四", "北京", 23));
        users.add(new User("赵六", "上海", 26));
        return users;
    }
}
