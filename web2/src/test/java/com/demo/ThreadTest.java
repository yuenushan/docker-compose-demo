package com.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int taskSize = 20;
        for (int i = 0; i < taskSize; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.put(finalI);
                        System.out.println("生产：" + finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int take = queue.take();
                        if (take == 19) {
                            System.out.println("结束消费");
                            return;
                        }
                        System.out.println("消费" + take);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        executorService.shutdown();
    }
}
