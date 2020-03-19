package com.jcc.java.spi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcc.java.spi.domyself.MyDriver;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * @program: javaknowledge->SpiDemoTest
 * @description: spi demo test
 * @author: jinchuanchuan1@le.com
 * @create: 2019-12-20 17:07
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiDemoTest {

//    @Test
    public void TestSpi(){
        ServiceLoader load = ServiceLoader.load(SpiInterface.class);
        Iterator<SpiInterface> iterator = load.iterator();
        while (iterator.hasNext()) {
            SpiInterface spi = iterator.next();
            spi.println();
        }
    }

//    @Test
    public void TestJDBC() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/le_demo?serverTimezone=UTC";
        String user = "root";
        String password = "jiechuan";

        //Mysql驱动
        Class.forName("java.sql.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection.toString());

        //自定义驱动
//        Class.forName("com.jcc.java.spi.domyself.MyDriver");
//        Connection mysqlConnection = new MyDriver().connect(url, new Properties());
//        System.out.println(mysqlConnection.toString());
    }
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Test
    public void test01() {
//        if (StringUtils.isBlank("123") && StringUtils.isBlank(null)) {
//            System.out.println("-----------");
//        } else {
//            System.out.println("2222222222");
//        }
        Map<String, String> vipInfoMap = vipInfoMap = new HashMap<String, String>();;
        vipInfoMap.put(null,"1");
//        Object o = vipInfoMap;
//        boolean b = o instanceof String;
//        System.out.println(b);
        try {
            OBJECT_MAPPER.writeValueAsString(vipInfoMap);
        } catch (Exception e) {
            System.out.println("-------" + e);
        }


    }
}
