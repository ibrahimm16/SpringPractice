package com.ibrahim.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.function.Predicate;

public class Multithreading {

    static List<Integer> nums;
    int i = 0;

    void doStuff(){
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        nums = new CopyOnWriteArrayList<>();
        Map<?, ?> map = new ConcurrentHashMap<>();
        Set<?> set = new CopyOnWriteArraySet<>();


        for(int i = 0; i < 1000; i++) {
            threadPool.execute(getRunnable());
        }

        System.out.println(i);

        threadPool.shutdown();
    }

    public static void main(String[] args) {
        Multithreading multithreading = new Multithreading();
        multithreading.doStuff();
    }

    Runnable getRunnable() {
        return () -> {
//            nums.stream()
//                    .filter((i) -> i % 3 == 0)
//                    .forEach(System.out::println);
//
//            nums.clear();
//            for (int i = 0; i < ((int) (Math.random() * 100.0)); i++) {
//                nums.add((int) (Math.random() * 100.0));
//            }

            synchronized (this) {
                i++;
            }
        };
    }
}
