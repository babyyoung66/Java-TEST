package com.junle.test;

public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"线程的优先级为："+Thread.currentThread().getPriority());

        Priority priority=new Priority();
        Thread t1=new Thread(priority);
        Thread t2=new Thread(priority);
        Thread t3=new Thread(priority);
        Thread t4=new Thread(priority);
        Thread t5=new Thread(priority);

        //设置优先级,默认为5
        t1.setPriority(3);
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(5);
        t3.start();

        t4.setPriority(4);
        t4.start();

        t5.setPriority(Thread.MAX_PRIORITY);
        t5.start();

    }
}

class Priority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程的优先级为："+Thread.currentThread().getPriority());
    }
}

