package com.junle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashmap {
    public static void main(String[] args) {
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                Map<Long, String> conMap = new ConcurrentHashMap<>();
                for (long i = 0; i < 1000; i++) {
                    conMap.put(i, "");
                }
                for (Map.Entry<Long, String> entry : conMap.entrySet()) {
                    Long key = entry.getKey();
                    if (key%2==0) {
                        conMap.remove(key);
                    }
                }
//concurrenthashmap可同时进行读写
                for (Map.Entry<Long, String> entry : conMap.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
        });
        thread.start();

    }
}
