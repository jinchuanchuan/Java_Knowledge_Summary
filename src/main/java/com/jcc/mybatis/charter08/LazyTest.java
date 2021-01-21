package com.jcc.mybatis.charter08;

import com.jcc.mybatis.charter08.mapper.OrdersMapper;
import com.jcc.mybatis.dto.Orders;
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
    public void testLazy(){
        String statement = "com.ys.lazyload.OrdersMapper.getOrderByOrderId";
        //创建OrdersMapper对象，mybatis自动生成mapepr代理对象
        OrdersMapper orderMapper = session.getMapper(OrdersMapper.class);
        List<Orders> orders = orderMapper.getOrderByOrderId();//第一步
        for(Orders order : orders){
            System.out.println(order.getUser());//第二步
        }
        session.close();
    }
}
