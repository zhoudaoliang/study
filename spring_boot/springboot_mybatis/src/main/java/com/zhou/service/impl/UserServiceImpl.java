package com.zhou.service.impl;

import com.zhou.dao.UserDao;
import com.zhou.domain.User;
import com.zhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public List<User> findAll() {

        //redis的key
        String key = "alluser";
        //先查询redis中是否有数据,如果有直接返回redis的数据
        List<User> users = (List<User>)redisTemplate.boundValueOps(key).get();
        if (users!=null){
            return users;
        }
        //如果没有，查询数据库
        users = userDao.findAll();
        //将查询到的数据库数据存入到redis中
        if (users!=null && users.size()>0){
            redisTemplate.boundValueOps(key).set(users);
        }

        return users;
    }
}
