package com.jcc.java.spi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcc.java.spi.domyself.MyDriver;
import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
//import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
//import org.junit.runner.RunWith;
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
//@RunWith(SpringRunner.class)
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

//    @Test
    public void test02() {
        String str1 = "str";
//        String str2 = "1235";
//        String str3 = "sds33dfg";
//        System.out.println("str1------" + isNumeric(str1));
//        System.out.println("str2------" + isNumeric(str2));
//        System.out.println("str3------" + isNumeric(str3));
//        reverse(-123);
        Character.isDigit(1);
        char[] chars = str1.toCharArray();
        System.out.println("chars=" + chars);
    }
//    @Test
    public void test03() {
//        isPalindrome01(10);
        int[] ints = {2, 3, 4};
        twoSum(ints, 6);

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
    //leetcode第7题
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        //判断正负数
        boolean flag = false;
        if (x <= 0) {
            flag = true;
        }
        //分割字符串
        String str = String.valueOf(x);
        String[] sArray = str.split("");

        for(int i = sArray.length - 1; i >= 0; i--) {
            if(sArray.length -1 == i && sArray[i] == "0") {
                continue;
            }
            System.out.println("i=" + i);
            //去掉末尾的负号
            if(flag && sArray[i].equals("-")) {
                continue;
            }
            sb.append(sArray[i]);
        }
        Integer result = new Integer("");
        if(flag && -Integer.valueOf(sb.toString()) < Integer.MIN_VALUE) {
            result = 0;
        }
        if (Integer.valueOf(sb.toString()) > Integer.MAX_VALUE){
            result = 0;
        }
        if (result != 0) {
            result = flag ? -Integer.valueOf(sb.toString()) : Integer.valueOf(sb.toString());
        }
        return result;
    }

    /**
     * leetcode 第9题，回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //1.先判断负数，负数直接返回
        //2.取模，反转数，进行比较
        if (x < 0) {
            return false;
        }
        int rev = 0;
        while(x > 0) {
            int temp = x % 10;
            rev = rev * 10 + temp;
            x = x/10;
        }
        if(x == rev) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome01(int x) {
        //1.转换为char数组
        //2.双指针：一前一后进行比较
        char[] chars = String.valueOf(x).toCharArray();
        int pre = 0;
        int end = chars.length - 1;
        boolean result = false;
        while(chars[pre] == chars[end]) {
            if(end - pre >= 1) {
                pre++;
                end--;
            } else {
                break;
            }
        }
        if(end - pre <= 0) {
            result = true;
        }
        return result;
    }
    public int[] twoSum(int[] nums, int target) {
        //1.双指针思路
        //2.头尾指针，同时向中间移动
        //3.如果加和大于target,且nums[pre] > nums [end], pre++;
        //4.如果加和大于target,且nums[pre] < nums [end], end--;
        //5.如果加和小于target,且nums[pre] < nums [end], pre++;
        //6.如果加和小于target,且nums[pre] > nums [end], end--;
        int pre = 0;
        int end = nums.length-1;
        while(pre < end) {
            int temp = nums[pre] + nums[end];
            if(temp > target){
                if(nums[pre] > nums [end]) {
                    pre++;
                } else {
                    end--;
                }
            }
            if(temp < target){
                if(nums[pre] < nums [end]) {
                    pre++;
                } else {
                    end--;
                }
            }
            if(temp == target) {
                return new int[]{pre, end};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
