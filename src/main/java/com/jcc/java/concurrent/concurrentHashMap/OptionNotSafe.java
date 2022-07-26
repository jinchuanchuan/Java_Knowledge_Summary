package com.jcc.java.concurrent.concurrentHashMap;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class OptionNotSafe implements Runnable{
    private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap();
    private static final String key = "小明";
    public static void main(String[] args) throws InterruptedException {
        map.put("小明", 0);
        Thread t1 = new Thread(new OptionNotSafe());
        Thread t2 = new Thread(new OptionNotSafe());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("小明：" + map.get("小明"));
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            while(true) {
                Integer score = map.get("小明");
                Integer newScore = score + 1;
                boolean b = map.replace(key, score, newScore);
                if (b) break;
            }
        }
    }
}
