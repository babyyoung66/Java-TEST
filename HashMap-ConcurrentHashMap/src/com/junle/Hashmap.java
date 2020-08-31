package com.junle;

import java.util.HashMap;
import java.util.UUID;

public class Hashmap {

    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i <=10000; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public  void  run() {
                    synchronized (map) {
                        map.put(UUID.randomUUID().toString(), "");
                    }
                }

            }).start();
        }
        System.out.println(map.size());
    }

}
