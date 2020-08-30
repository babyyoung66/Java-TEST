package com.junle.test;

public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"线程的优先级为："+Thread.currentThread().getPriority());


    }
}

class priority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程的优先级为："+Thread.currentThread().getPriority());
    }
}

