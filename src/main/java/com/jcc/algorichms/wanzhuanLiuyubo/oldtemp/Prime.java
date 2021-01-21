package com.jcc.algorichms.wanzhuanLiuyubo.oldtemp;

/**
 * @program: javaknowledge->Prime
 * @description:
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-28 18:02
 **/
public class Prime {
    public static boolean isPrime(int n) {
        for (int x = 2; x * x <= n; x++) {
            if (n%x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("result :" + isPrime(11));
    }

}
