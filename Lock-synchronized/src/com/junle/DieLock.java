package com.junle;

public class DieLock {
    public static void main(String[] args) {
        Hero timo=new Hero();
        timo.name="提莫";
        Hero xiazi=new Hero();
        xiazi.name="盲僧";
        Hero jie=new Hero();
        jie.name="劫";

        //1.创建第一个线程 t1
        Thread t1=new Thread() {
            public void run() {
                //1.1占用提莫
                synchronized (timo) {
                    System.out.println("t1线程抢到了提莫!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1线程想拥有盲僧!");
                    System.out.println("t1线程等待...");
                    synchronized (xiazi) {
                        System.out.println("被其他线程占据中...");

                    }
                }
            }
        };
        t1.start();

        //2.创建第二个线程 t2
        Thread t2=new Thread() {
            public void run() {
                //2.1占用提莫
                synchronized (xiazi) {
                    System.out.println("t2线程抢到了盲僧!");
                    try {
                        //2.2线程短暂睡眠
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2线程想拥有劫!");
                    System.out.println("t2线程等待...");
                    synchronized (jie) {
                        System.out.println("被其他线程占据中...");

                    }
                }
            }
        };
        t2.start();

        //3.创建第三个线程 t3
        Thread t3=new Thread() {
            public void run() {
                //3.1占用劫
                synchronized (jie) {
                    System.out.println("t3线程抢到了劫!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t3线程想拥有提莫!");
                    System.out.println("t3线程等待...");
                    synchronized (timo) {
                        System.out.println("被其他线程占据中...");

                    }
                }
            }
        };
        t3.start();
    }
}
