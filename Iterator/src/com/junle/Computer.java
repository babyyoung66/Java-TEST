package com.junle;

public class Computer implements Comparable {
    private double price;//私有属性；
    //构造方法；
    public Computer(double price) {
        super();
        this.price = price;
    }
    //实现Comparable接口中的compareTo方法；
    @Override
    public int compareTo(Object o) {
        Computer c=(Computer) o;

        if(this.price>c.price){
            return 1;
        }else if(this.price<c.price){
            return -1;
        }else{
            return 0;
        }
    }
    //重写toString()方法；
    @Override
    public String toString() {
        return"Computer [price=" + price + "]";
    }
}
