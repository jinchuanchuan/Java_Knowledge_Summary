package com.jcc.mybatis.charter09;

import com.jcc.mybatis.charter09.mapper.UserMapper;
import com.jcc.mybatis.dto.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @program: javaknowledge->LazyTest
 * @description: curd
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-08 16:00
 **/
public class LazyTest {
    //定义 SqlSession
    SqlSession session =null;

    @Before
    public void init(){
        //定义mybatis全局配置文件
        String resource = "mybatis-config.xml";
        //加载 mybatis 全局配置文件
        InputStream inputStream = LazyTest.class.getClassLoader()
                .getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //根据 sqlSessionFactory 产生 session
        session = sessionFactory.openSession();
    }

    @Test
    public void testSelectOrderAndUserByOrderId() throws Exception {
        //根据 sqlSessionFactory 产生 session
        String statement = "one.to.one.mapper.OrdersMapper.selectOrderAndUserByOrderID";
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //第一次查询，发出sql语句，并将查询的结果放入缓存中
        User u1 = userMapper.selectUserById(1);
        System.out.println(u1);

        //第二次查询，由于是同一个sqlSession,会在缓存中查找查询结果
        //如果有，则直接从缓存中取出来，不和数据库进行交互
        User u2 = userMapper.selectUserById(1);
        System.out.println(u2);

        session.close();
    }

    /**
     * 同样是对user表进行两次查询，只不过两次查询之间进行了一次update操作。
     * 这样sqlsession缓存失效
     * @throws Exception
     */
    @Test
    public void testSelectOrderAndUserByOrderIdUpdateCommit() throws Exception {
        //根据 sqlSessionFactory 产生 session
//        SqlSession sqlSession = sessionFactory.openSession();
        String statement = "one.to.one.mapper.OrdersMapper.selectOrderAndUserByOrderID";
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //第一次查询，发出sql语句，并将查询的结果放入缓存中
        User u1 = userMapper.selectUserById(1);
        System.out.println(u1);

        //第二步进行了一次更新操作，sqlSession.commit()
        u1.setSex("女");
        userMapper.updateUserById(u1);
        session.commit();

        //第二次查询，由于是同一个sqlSession.commit(),会清空缓存信息
        //则此次查询也会发出 sql 语句
        User u2 = userMapper.selectUserById(1);
        System.out.println(u2);

        session.close();
    }
}
