package com.jcc.test.futureTest;

import java.util.concurrent.*;

public class FutureThenRunTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("先执行第一个CompletableFuture方法任务");
                    return "捡田螺的小男孩";
                }
        );

        CompletableFuture thenRunFuture = orgFuture.thenRun(() -> {
            System.out.println("接着执行第二个任务");
        });

        System.out.println(thenRunFuture.get());
        System.out.println("————————————————————————————————————————————————————————————");
        // ————————————————————————————————————————————————————————————
        //可以自定义线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        //runAsync的使用
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> System.out.println("run,关注公众号:捡田螺的小男孩"), executor);
        //supplyAsync的使用
        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            System.out.print("supply,关注公众号:捡田螺的小男孩");
            return "捡田螺的小男孩"; }, executor);
        //runAsync的future没有返回值，输出null
        System.out.println(runFuture.join());
        //supplyAsync的future，有返回值
        System.out.println(supplyFuture.join());
        executor.shutdown(); // 线程池需要关闭
        // ————————————————————————————————————————————————————————————
        System.out.println("————————————————————————————————————————————————————————————");
        CompletableFuture<Object> orgFuture01 = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                    throw new RuntimeException();
                }
        ).exceptionally(e -> {
//            e.printStackTrace();
            return "你的程序异常啦";
        });

//        CompletableFuture<String> exceptionFuture = orgFuture01.exceptionally((e) -> {
//            e.printStackTrace();
//            return "你的程序异常啦";
//        });

        System.out.println(orgFuture01.get());
        System.out.println("————————————————————————————————————————————————————————————");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            int i = 1/0;
            return 100;
        });
//        future.join();
//        future.get();
        System.out.println("————————————————————————————————————————————————————————————");
        CompletableFuture<Integer> future10 = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<String> future20 = CompletableFuture.supplyAsync(() -> {
            return "abc";
        });
        CompletableFuture<String> f =  future10.thenCombine(future20, (x,y) -> y + "-" + x);
        System.out.println(f.get());

    }
}
