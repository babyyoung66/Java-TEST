package com.junle;

public class LamdaTest {

    //静态内部类
    static class Lamda2 implements Lamda{

        @Override
        public void lamda() {
           System.out.println("静态内部类");
        }
    }
    public static void main(String[] args) {
        Lamda lamda=new Tlamda();
        lamda.lamda();

        Lamda lamda2=new Lamda2();
        lamda2.lamda();

        //局部内部类
        class lamda3 implements Lamda{
            @Override
            public void lamda() {
                System.out.println("局部内部类");
            }
        }
        Lamda lamda3=new lamda3();
        lamda3.lamda();

        //匿名内部类
        lamda=new Tlamda(){
          public void lamda(){
              System.out.println("匿名内部类");
          }
        };
        lamda.lamda();

        //lamda表达
        lamda=()-> {
            System.out.println("Lamda表达式！！！！");
        };
        lamda.lamda();

    }
}

interface Lamda{
    void lamda();
}

class Tlamda implements Lamda{

    @Override
    public void lamda() {
        System.out.println("implement代理方法！！！！");
    }
}