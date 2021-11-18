package ru.job4j.api;

import java.util.List;

public class LocalVariable {
    public static void main(String[] args) {
        var first = 1;
        var second = 2;
        var third = 3;
        System.out.println(first + " " + second + " " + third);
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        for (var v : values) {
            System.out.println("this value: " + v);
        }
    }
}
