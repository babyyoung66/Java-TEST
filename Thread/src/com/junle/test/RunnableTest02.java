package com.junle.test;

//实现runnable接口
//多线程操作一个资源
public class RunnableTest02 implements Runnable{

    public static void main(String[] args) {
        RunnableTest02 runnableTest=new RunnableTest02();//相当于一个service层方法，然后可以有多个线程同时去操作这个方法

        new Thread(runnableTest,"小明").start();
        new Thread(runnableTest,"小黄").start();
        new Thread(runnableTest,"黄牛党").start();

    }
    //资源数
    private int ticketNum=10;
    private boolean flag=true;
    @Override
    public void run() {
        while (flag){
            if (ticketNum <=0){
                this.flag=false;
            }

            //使用锁解决重复操作问题
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum-- +"张票");
            }

            //模拟延迟


        }
    }



}
