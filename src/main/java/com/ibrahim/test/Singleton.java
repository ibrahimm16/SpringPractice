package com.ibrahim.test;

public class Singleton {

    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public void add(int a, int b) {
        System.out.println(a + b);
    }


    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();

        singleton.add(1, 10);
    }
}
