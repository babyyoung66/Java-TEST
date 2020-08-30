package com.junle.test;

import java.util.concurrent.*;

public class CallableTest implements Callable<String> {

    @Override
    public String call() {
        String msg="线程"+Thread.currentThread().getName()+"正在执行！";
        return msg;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest c1=new CallableTest();
        CallableTest c2=new CallableTest();
        CallableTest c3=new CallableTest();
        //创建线程池
        ExecutorService exs= Executors.newFixedThreadPool(3);//三个线程数

        //用future获取结果
        Future<String> r1=exs.submit(c1);
        Future<String> r2=exs.submit(c2);
        Future<String> r3=exs.submit(c3);
        //使用get()取出结果
        System.out.println(r1.get());
        System.out.println(r2.get());
        System.out.println(r3.get());

        //关闭服务（线程池）
        exs.shutdown();

    }
}
