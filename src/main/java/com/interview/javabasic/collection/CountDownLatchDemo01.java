package com.interview.javabasic.collection;

import java.util.concurrent.CountDownLatch;

/**
 * @program: javaknowledge->CountDownLatchDemo01
 * @description: demo 01
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-26 15:02
 **/
public class CountDownLatchDemo01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程和他的两个小兄弟约好去吃火锅");
        System.out.println("主线程进入了饭店");
        System.out.println("主线程想要开始动筷子吃饭");
        //new一个计数器，初始值为2，当计数器为0时，主线程开始执行
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程1——小兄弟A 正在到饭店的路上");
                    Thread.sleep(3000);
                    System.out.println("子线程1——小兄弟A 到饭店了");
                    //一个小兄弟到了，计数器-1
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程2——小兄弟B 正在到饭店的路上");
                    Thread.sleep(3000);
                    System.out.println("子线程2——小兄弟B 到饭店了");
                    //另一个小兄弟到了，计数器-1
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        //主线程等待，直到其他两个小兄弟也进入饭店（计数器==0），主线程才能吃饭
        latch.await();
        System.out.println("主线程终于可以开始吃饭了～");
    }

}
