package com.jcc.java.lambda;

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
        List featrues = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        featrues.forEach(n -> System.out.println(n));
    }
}
