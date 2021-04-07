package com.jcc.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: javaknowledge->IteratorList
 * @description: 迭代List
 * @author: jinchuanchuan1@le.com
 * @create: 2020-05-11 20:11
 **/
public class IteratorList {
    public static void main(String[] args) {
//        List featrues = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        featrues.forEach(n -> System.out.println(n));
//        Long id = null;
//        String str = String.valueOf(id);
//        System.out.println(str);
//        String str01 = null;
//        Integer value = Integer.valueOf(str01);
//        System.out.println(value);
//        Integer[] arr = {1,2,3,4,5};
//        List<Integer> integers = Arrays.asList(arr);
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr)) ;
//        list.add(6);
//        System.out.println(list);

    }
    public static boolean isBlank(String str) {
        if (str == null || str.length() == 0)
            return true;
        return false;
    }
}
