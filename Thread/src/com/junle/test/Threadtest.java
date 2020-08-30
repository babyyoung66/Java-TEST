package com.junle.test;

//继承Thread类，重写run
public class Threadtest extends Thread {
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            try {
                Thread.sleep(2);
                System.out.println("Thread线程启动："+i);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Threadtest thread=new Threadtest();
        thread.start();

        for(int i=0;i<30;i++){
            Thread.sleep(1);
            System.out.println("main主线程："+i);
        }
    }
}
