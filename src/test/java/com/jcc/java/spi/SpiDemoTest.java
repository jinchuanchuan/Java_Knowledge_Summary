package com.jcc.java.spi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcc.java.spi.domyself.MyDriver;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

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
//    @Test
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
//        try {
//            OBJECT_MAPPER.writeValueAsString(vipInfoMap);
//        } catch (Exception e) {
//            System.out.println("-------" + e);
//        }
        System.out.println("----"+Long.valueOf(""));

    }

    @Test
    public void test02() {
        String str1 = "str";
        String str2 = "1235";
        String str3 = "sds33dfg";
        System.out.println("str1------" + isNumeric(str1));
        System.out.println("str2------" + isNumeric(str2));
        System.out.println("str3------" + isNumeric(str3));
    }

    public static Boolean isNumeric(String str){
        Pattern pattern = compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    public static boolean isInteger(String value) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(value);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
