package com.junle.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Threadpool {
    public class addnum {
        public int num;

        public addnum(int i) {
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        int threadPoolSize=15;
        for (int i = 0; i < threadPoolSize; i++) {
            Thread.sleep(500);
            System.out.println("任务:"+i);
        }
        for (int i = 0; i < threadPoolSize; i++) {
        threadPool.execute(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                    try {
                       int i=0;
                       i++;
                        Thread.sleep(5000);
                        System.out.println("任务:"+i);
                    }catch (Exception e){
                    }
                }
        });
        }
        threadPool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
