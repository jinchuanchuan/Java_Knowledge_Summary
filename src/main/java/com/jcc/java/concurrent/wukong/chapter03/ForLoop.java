package com.jcc.java.concurrent.wukong.chapter03;

/**
 * @program: javaknowledge->ForLoop
 * @description:
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-08 14:59
 **/
public class ForLoop {
    public static void main(String[] args) {
        //
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }
    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("执行了任务");
        }
    }
}
