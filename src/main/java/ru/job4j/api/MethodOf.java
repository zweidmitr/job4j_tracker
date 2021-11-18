package ru.job4j.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MethodOf {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        numbers.forEach(System.out::print);
        System.out.println("\n=====================");
        numbers.forEach(s -> System.out.print(s));
        System.out.println("\n=====================");
        Set.of(5, 1, 3).forEach(System.out::print);
        System.out.println("\n=====================");
        Map.of("first", 1, "second", 2).forEach((v, k) -> System.out.print(v + " " + k + " "));
        System.out.println("\n=====================");

    }
}
