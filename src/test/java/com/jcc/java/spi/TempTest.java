package com.jcc.java.spi;

import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: javaknowledge->TempTest
 * @description: 其他测试用例
 * @author: jinchuanchuan1@le.com
 * @create: 2020-04-01 18:22
 **/
//@RunWith(SpringRunner.class)
@SpringBootTest
public class TempTest {
    String str = "1234";
//    @Test
    public void test01() {
        System.out.println("result:" + StringUtils.isNumeric(str));
    }
//    @Test
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
//    @Test
    public void testLock() {
        ReentrantLock reentrantLock = new ReentrantLock();

    }
}
