package com.jcc.java.temp;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: javaknowledge->Decrease
 * @description: 递减
 * @author: jinchuanchuan1@le.com
 * @create: 2021-03-03 16:19
 **/
public class Decrease {
    public static void main(String[] args) {
        getDecr(100d, 10);
    }
    public static List<Double> getDecr(Double num, int count) {
        Double temp = num;
        List<Double> res = new ArrayList<>();

        while(count > 0) {
            if(count == 1) {
                res.add(temp);
                System.out.println("count = " + count + "; random = " + temp);
                count--;
            } else {
                double max = temp;
                double min = temp / count;
                // System.out.println("min : " + min + "; max : " + max);
                Random r = new Random();
                double random = min + (max - min) * r.nextDouble();
                System.out.println("count = " + count + "; random = " + random);
                temp = random;
                res.add(random);
                count--;
            }
        }
        return res;
    }
}
