package com.jcc.mybatis.charter05;

import com.jcc.mybatis.charter05.mapper.UserMapper;
import com.jcc.mybatis.dto.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
public class CRUDTest {
    //定义 SqlSession
    SqlSession session =null;

    @Before
    public void init(){
        //定义mybatis全局配置文件
        String resource = "mybatis-config.xml";
        //加载 mybatis 全局配置文件
        InputStream inputStream = CRUDTest.class.getClassLoader()
                .getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //根据 sqlSessionFactory 产生 session
        session = sessionFactory.openSession();
    }

    //根据id查询user表数据
    @Test
    public void testSelectUserById() throws Exception{
        //获取mapper接口
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }
//-----------------------------------------------
    //根据id查询user表数据
    @Test
    @Deprecated
    public void testSelectUserBayId(){
        /*这个字符串由 userMapper.xml 文件中 两个部分构成
            <mapper namespace="com.jcc.mybatis.charter02.mapper.userMapper"> 的 namespace 的值
            <select id="selectUserById" > id 值*/
        String statement = "com.jcc.mybatis.charter02.mapper.userMapper.selectUserById";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
        session.close();
    }

    //查询所有user表所有数据
    @Test
    public void testSelectUserAll(){
        String statement = "com.jcc.mybatis.charter02.mapper.userMapper.selectUserAll";
        List<User> listUser = session.selectList(statement);
        for(User user : listUser){
            System.out.println(user);
        }
        session.close();
    }

    //模糊查询：根据 user 表的username字段
    @Test
    public void testSelectLikeUserName(){
        String statement = "com.jcc.mybatis.charter02.mapper.userMapper.selectLikeUserName";
        List<User> listUser = session.selectList(statement, "%t%");
        for(User user : listUser){
            System.out.println(user);
        }
        session.close();

    }
    //向 user 表中插入一条数据
    @Test
    public void testInsertUser(){
        String statement = "com.jcc.mybatis.charter02.mapper.userMapper.insertUser";
        User user = new User();
        user.setUsername("Bob");
        user.setSex("女");
        session.insert(statement, user);
        //提交插入的数据
        session.commit();
        session.close();
    }

    //根据 id 更新 user 表的数据
    @Test
    public void testUpdateUserById(){
        String statement = "com.jcc.mybatis.charter02.mapper.userMapper.updateUserById";
        //如果设置的 id不存在，那么数据库没有数据更改
        User user = new User();
        user.setId(4);
        user.setUsername("jim");
        session.update(statement, user);
        session.commit();
        session.close();
    }


    //根据 id 删除 user 表的数据
    @Test
    public void testDeleteUserById(){
        String statement = "com.jcc.mybatis.charter02.mapper.userMapper.deleteUserById";
        session.delete(statement,4);
        session.commit();
        session.close();
    }
}
