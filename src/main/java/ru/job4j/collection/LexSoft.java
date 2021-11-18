package ru.job4j.collection;

import java.util.Comparator;

public class LexSoft implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split(". ");
        String[] arrayRight = right.split(". ");

        int intLeft = Integer.parseInt(arrayLeft[0]);
        int intRight = Integer.parseInt(arrayRight[0]);

        return Integer.compare(intLeft, intRight);

    }
}
