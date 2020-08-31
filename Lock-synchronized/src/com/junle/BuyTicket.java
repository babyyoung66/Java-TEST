package com.junle;

public class BuyTicket {
    public static void main(String[] args) {
        saleTicket shop=new saleTicket();

        new Thread(shop,"学生小黄").start();
        new Thread(shop,"工人老李").start();
        new Thread(shop,"票贩子").start();
    }
}

class saleTicket implements Runnable{
    private int ticketNum=20;//票数
    boolean flag = true;
    @Override
    public void run() {
            while(flag){
                try {
                    synchronized (this){
                        buy();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    private void buy() throws InterruptedException {
        if (ticketNum<=0){
            this.flag=false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"--->>买到了第"+ticketNum-- +"张票....");

    }
}
