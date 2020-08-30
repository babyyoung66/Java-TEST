package com.junle.test;

//实现runnable接口
public class RunnableTest01 implements Runnable{

    private static String winer;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //安排兔子
            if (Thread.currentThread().getName().equals("兔子") && i%10==0){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //为真则跳出
        boolean flag=ganeOver(i);
        if (flag){
            break;
        }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }
    private boolean ganeOver(int steps){
        if (winer!=null){
            return true;
        }else {
            if (steps >= 100){
                winer=Thread.currentThread().getName();
                System.out.println("Winer  Is："+winer);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableTest01 runnableTest=new RunnableTest01();
        new Thread(runnableTest,"兔子").start();
        new Thread(runnableTest,"乌龟").start();

    }

}
