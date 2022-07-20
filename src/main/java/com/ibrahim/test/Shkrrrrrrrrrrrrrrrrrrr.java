package com.ibrahim.test;

import java.util.*;

public class Shkrrrrrrrrrrrrrrrrrrr {


    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        list.add(1);
//
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(3);
//        set.stream().forEach(System.out::println);

        Test t1 = new Test(10, "1");
        Test t2 = new Test(5, "2");
        Test t3 = new Test(7, "3");
        Test2 t4 = new Test2(22, "4");

        List<Test> list = Arrays.asList(t1, t2, t3, t4);

        list.stream()
                .filter(s -> s.age > 10)
                .sorted()
                .forEach(System.out::println);

        System.out.println(list);
    }

    static class Test2 extends Test {

        Test2(Integer age, String name) {
            super(age, name);
        }

        void print() {
            System.out.println("name: " + name);
            System.out.println("age: " + age);
        }
    }

    static class Test implements Comparable<Test> {

        Integer age;
        String name;

        Test(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            else if (!(o instanceof Test)) {
                return false;
            }
            Test test = (Test) o;
            return Objects.equals(age, test.age) &&
                    Objects.equals(name, test.name);
        }

        @Override
        public String toString() {
            return "Test{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Test o) {
            return age - o.age;
        }
    }
}
