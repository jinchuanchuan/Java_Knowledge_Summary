package com.jcc.java.generics;

/**
 * @program: javaknowledge->ErasureType
 * @description: 泛型擦除
 * @author: jinchuanchuan1@le.com
 * @create: 2020-08-19 16:19
 **/
public class ErasureType {
//上界通配符

    public static void main(String[] args) {
        Integer app = null;
        if (1 != app) {
            System.out.println("ok");
        }
    }
}
