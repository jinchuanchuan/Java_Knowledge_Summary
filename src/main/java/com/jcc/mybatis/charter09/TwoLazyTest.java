package com.jcc.mybatis.charter09;

import com.jcc.mybatis.charter09.mapper.UserMapper;
import com.jcc.mybatis.dto.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @program: javaknowledge->LazyTest
 * @description: curd
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-08 16:00
 **/
public class TwoLazyTest {
    //定义 SqlSession
    SqlSession session =null;
    SqlSessionFactory sessionFactory = null;

    @Before
    public void init(){
        //定义mybatis全局配置文件
        String resource = "mybatis-config.xml";
        //加载 mybatis 全局配置文件
        InputStream inputStream = TwoLazyTest.class.getClassLoader()
                .getResourceAsStream(resource);
        //构建sqlSession的工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //根据 sqlSessionFactory 产生 session
        session = sessionFactory.openSession();
    }

    @Test
    public void testTwoCache() throws Exception {
        //根据 sqlSessionFactory 产生 session
        SqlSession sqlSession1 = sessionFactory.openSession();
        SqlSession sqlSession2 = sessionFactory.openSession();

        String statement = "com.ys.twocache.UserMapper.selectUserByUserId";
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        //第一次查询，发出sql语句，并将查询的结果放入缓存中
        User u1 = userMapper1.selectUserById(1);
        System.out.println(u1);
        sqlSession1.close();//第一次查询完后关闭sqlSession

        //第二次查询，即使sqlSession1已经关闭了，这次查询依然不发出sql语句
        User u2 = userMapper2.selectUserById(1);
        System.out.println(u2);
        sqlSession2.close();
    }

    @Test
    public void testTwoCache02() throws Exception {
        //根据 sqlSessionFactory 产生 session
        SqlSession sqlSession1 = sessionFactory.openSession();
        SqlSession sqlSession2 = sessionFactory.openSession();
        SqlSession sqlSession3 = sessionFactory.openSession();

        String statement = "com.ys.twocache.UserMapper.selectUserByUserId";
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession2.getMapper(UserMapper.class);
        //第一次查询，发出sql语句，并将查询的结果放入缓存中
        User u1 = userMapper1.selectUserById(1);
        System.out.println(u1);
        sqlSession1.close();//第一次查询完后关闭sqlSession

        //执行更新操作，commit()
        u1.setUsername("aaa");
        userMapper3.updateUserById(u1);
        sqlSession3.commit();

        //第二次查询，由于上次更新操作，缓存数据已经清空（防止数据脏读），这里必须再次发出sql语句
        User u2 = userMapper2.selectUserById(1);
        System.out.println(u2);
        sqlSession2.close();
    }
}
