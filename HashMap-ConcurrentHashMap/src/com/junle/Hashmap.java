package com.junle;

import java.util.HashMap;
import java.util.UUID;

public class Hashmap {

    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        for (int i = 0; i < 100000; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                    System.out.println(map);
                }
            }).start();
        }
    }

}
