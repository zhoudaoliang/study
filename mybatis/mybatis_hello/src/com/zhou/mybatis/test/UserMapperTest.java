package com.zhou.mybatis.test;

import com.zhou.mapper.UserMapper;
import com.zhou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserMapperTest {

    static SqlSessionFactory sqlSessionFactory;
    /**
     * @BeforeClass 可以在Junit测试是标识一个static方法用于做初始化使用.<br/>
     *  1 标识了@BeforeClass注解的方法会在测试方法之前自动执行
     * @throws Exception
     */

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("beforeClass");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void selectUserById(){
        // SqlSession相当于 Jdbc 编程中的Connection连接对象,每次使用完一定要*及时*关闭
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUserById(1);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            for (User user : mapper.selectAll()) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(2, "lisi", 1));
            //手动提交事务
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void deleteUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUserById(2);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.insertUser(new User(0,"wangwu",1));
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

}
