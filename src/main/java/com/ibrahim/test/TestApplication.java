package com.ibrahim.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class TestApplication {

    static void printTimesTwo(Integer i) {
        System.out.println(i * 2);
    }

    static List<Integer> squareList(List<Integer> list) {
        return list.stream()
                .filter(i -> i < 50)
                .map(i -> i * i)
                .collect(Collectors.toList());
    }

    static void something(Map<String, Integer> map) {
//        map.entrySet()
//                .stream()
//                .forEach();
    }

    static Character chars(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = s.chars()
                .mapToObj(i->(char)i)
                .collect(Collectors.toList());

        int max = 0;
        for (Character c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            max = Math.max(max, count);
        }

        for (Character c : s.toCharArray()) {
            if (map.get(c) == max) return c;
        }

        return 'a';
    }

    static class Something {
        Integer i;

                Something(Integer i) {
            this.i = i;
                }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 51, 22, 103, -8, 4);

//        System.out.println(squareList(list));

        BigDecimal bd = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");

        System.out.println(bd.add(bd2));

        Map<String, Something> map = new HashMap<>();
        map.getOrDefault("", null);
        map.get("");



//        // for
//        for (Integer i : list) {
//            System.out.println(i);
//        }
//
//        // stream
//        list.stream()
//                .filter(num -> num != 3)
//                .map(num -> num * 2)
//                .forEach(System.out::println);














//        SpringApplication.run(TestApplication.class, args);
    }

















    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .serializationInclusion(JsonInclude.Include.NON_NULL);
        return new MappingJackson2HttpMessageConverter(builder.build());
    }
}