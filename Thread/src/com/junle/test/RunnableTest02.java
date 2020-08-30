package com.junle.test;

//实现runnable接口
//多线程操作一个资源
public class RunnableTest02 implements Runnable{
    //资源数
    private int ticketNum=10;
    @Override
    public void run() {


        while (true){

            if (ticketNum <=1){
                break;
            }
            //模拟延迟

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //使用锁解决重复操作问题
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum-- +"张票");
              }
        }
    }

    public static void main(String[] args) {
        RunnableTest02 runnableTest=new RunnableTest02();
        new Thread(runnableTest,"小明").start();
        new Thread(runnableTest,"小黄").start();
        new Thread(runnableTest,"黄牛党").start();

    }

}
