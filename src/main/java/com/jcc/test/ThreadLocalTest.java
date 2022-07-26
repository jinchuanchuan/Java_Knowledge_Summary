package com.jcc.test;

public class ThreadLocalTest {

        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        public static void main(String[] args) {

            new Thread(() -> {
                try {
                    for (int i = 0; i < 100; i++) {
                        threadLocal.set(i);
                        System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    threadLocal.remove();
                }
            }, "threadLocal1").start();


            new Thread(() -> {
                try {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    threadLocal.remove();
                }
            }, "threadLocal2").start();
        }

//    ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();
//    public static void main(String[] args) {
//        testThreadLocal();
//    }


    private static void testThreadLocal() {
        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("droidyue.com");
                // mStringThreadLocal.get();
                mStringThreadLocal.set("123");
                System.out.println(mStringThreadLocal.get());
            }
        };

        t.start();
    }

    // 每个线程获取ThreadLocal变量时，总是使用Thread自身作为key：
    // ThreadLocal相当于给每个线程都开辟了一个独立的存储空间，各个线程的ThreadLocal关联的实例互不干扰。
    // ThreadLocal一定要在finally中清除：threadLocalUser.remove();
    static ThreadLocal<User> threadLocalUser = new ThreadLocal<>();


    void processUser(User user) {
        try {
            threadLocalUser.set(user);
            step1();
            step2();
        } finally {
            threadLocalUser.remove();
        }
    }
    void step1() {
        User u = threadLocalUser.get();
        log();
        System.out.println("user info" + u);
    }

    void log() {
        User u = threadLocalUser.get();
        System.out.println("user info" + u);
    }

    void step2() {
        User u = threadLocalUser.get();
        System.out.println("user info" + u);
    }
}
