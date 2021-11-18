package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int temp = 0;
        int min = Math.min(o1.length(), o2.length());

        for (int i = 0; i < min; i++) {
            char a = o1.charAt(i);
            char b = o2.charAt(i);
            temp = Character.compare(a, b);
            if (temp != 0) {
                return temp;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
