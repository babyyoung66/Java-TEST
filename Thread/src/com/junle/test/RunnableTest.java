package com.junle.test;

//实现runnable接口
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(2);
                System.out.println("Runnable线程启动：" + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableTest runnableTest=new RunnableTest();
        new Thread(runnableTest).start();

        for(int i=0;i<30;i++){
            Thread.sleep(1);
            System.out.println("main主线程：" + i);
        }
    }

}
