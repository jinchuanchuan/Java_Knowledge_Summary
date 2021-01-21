package com.jcc.mybatis.charter03;

import com.jcc.mybatis.charter03.mapper.UserMapper;
import com.jcc.mybatis.dto.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @program: javaknowledge->UserAnnocationTest
 * @description: annocation test
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-08 16:42
 **/
public class UserAnnocationTest {
    //定义 SqlSession
    SqlSession session =null;

    @Before
    public void init(){
        //定义mybatis全局配置文件
        String resource = "mybatis-config.xml";
        //加载 mybatis 全局配置文件
        InputStream inputStream = UserAnnocationTest.class.getClassLoader()
                .getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //根据 sqlSessionFactory 产生 session
        session = sessionFactory.openSession();
    }

    //注解的增删改查方法测试
    @Test
    public void testAnncationCRUD() throws Exception{
        //根据session获取 UserMapper接口
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //调用selectUserById()方法
        User user = userMapper.selectUserById(5);
        System.out.println(user);

        //调用  insertUser() 方法
        User user1 = new User();
        user1.setUsername("aliks");
        user1.setSex("不详");
        userMapper.insertUser(user1);

        //调用 updateUserById() 方法
        User user2 = new User();
        user2.setId(6);
        user2.setUsername("lbj");
        userMapper.updateUserById(user2);

        //调用 () 方法
        userMapper.deleteUserById(6);

        session.commit();
        session.close();
    }
}
