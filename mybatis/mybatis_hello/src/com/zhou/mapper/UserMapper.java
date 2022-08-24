package com.zhou.mapper;

import com.zhou.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 根据id查询用户信息
     *
     * @param id 用户的id
     * @return
     */
    public User selectUserById(Integer id);


    /**
     * 查询全部
     *
     * @return
     */
    public List<User> selectAll();

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteUserById(Integer id);

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    public int insertUser(User user);
}
