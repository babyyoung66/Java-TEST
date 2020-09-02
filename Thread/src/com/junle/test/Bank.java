package com.junle.test;

public class Bank {
    public static  void main(String[] args) {
        Account account=new Account(10000,"小黄的工资卡");
        //同时取钱
        Drawing girlfriend=new Drawing(account,4396,"小黄的女朋友");
        Drawing you=new Drawing(account,4000,"小黄");
        girlfriend.start();
        you.start();
    }
}
class  Account{
    int money;//余额
    String userName;

    public Account(int money, String userName) {
        this.money = money;
        this.userName = userName;
    }
}
//取钱
class  Drawing extends Thread{
    Account account;
    int DrawingMoney;//取/存
    int currentMoney;//当前余额

    public Drawing(Account account, int DrawingMoney, String name){
        super(name);
        this.account=account;
        this.DrawingMoney=DrawingMoney;

    }

    public   void  run(){
        synchronized (account){
            if (account.money-DrawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"您好，您的余额不足，无法取出！");
                return;
            }
            //模拟延迟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //取钱计算当前余额
            account.money=account.money - DrawingMoney;
            //手里的钱

            System.out.println(Thread.currentThread().getName()+"取出金额为："+DrawingMoney+"，当前账户余额为："+account.money);

        }
    }
}