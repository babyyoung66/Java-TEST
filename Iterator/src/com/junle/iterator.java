package com.junle;

import java.util.Iterator;
import java.util.TreeSet;

//迭代器
public class iterator {
    public static void main(String[] args) {
//创建TreeSet;
        TreeSet<Computer> treeSet= new TreeSet<Computer>();

//创建Computer对象；
        Computer computer1=new Computer(3000);
        Computer computer2=new Computer(2650);
        Computer computer3=new Computer(5878.8);
        Computer computer4=new Computer(6000.78);

//将Computer对象加入到treeSet中；
        treeSet.add(computer1);
        treeSet.add(computer2);
        treeSet.add(computer3);
        treeSet.add(computer4);
        //为treeSet创建迭代器；
        Iterator<Computer> it= treeSet.iterator();
        //遍历treeSet
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
