package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> bestList = new ArrayList<>();
        bestList.add("Petr");
        bestList.add("Ivan");
        bestList.add("Stepan");

        for (String value:bestList) {
            System.out.println(value);
        }
    }
}
