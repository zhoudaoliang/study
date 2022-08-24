package com.zhou.mybatis.test;


import com.zhou.mapper.UserMapper;
import com.zhou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MybatisTest {
    @Test
    public void test() throws Exception {
        // 先由Mybatis的核心配置文件mybatis-config.xml创建sqlSessionFactory类
        /**
         * Resources类用于读取mybatis的核心配置文件
         */
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        // SqlSessionFactoryBuilder专门用于创建SqlSessionFactory类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        System.out.println(sqlSessionFactory);

    }

    @Test
    public void test2() throws Exception {
        // 测试的目标是,执行select * from t_user where id = 1 将数据查询出来.并封装成为User对象返回
        //1 由mybatis的核心配置文件创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //2 再由SqlSessionFactory对象创建SqlSession( SqlSession对象相当于JDBC编程中的Connection连接对象,每次用完要关闭 )
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //3 通过SqlSession获取Mapper的实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //4 调用Mapper方法
            User user = mapper.selectUserById(1);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }

    }

}
