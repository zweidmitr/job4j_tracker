package ru.job4j.stream.cards;

import java.util.stream.Stream;

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        String[] levels = {"level 1", "level 2", "level 3"};
        String[] tasks = {"task 1", "task 2", "task 3", "task 4"};
        for (String level : levels) {
            for (String task : tasks) {
                System.out.println(level + " - " + task);
            }
        }
        System.out.println("============================");
        Stream.of(levels)
                .flatMap(level -> Stream.of(tasks)
                        .map(task -> level + " - " + task))
                .forEach(System.out::println);
        System.out.println("============================");
        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        Stream.of(suits)
                .flatMap(suit -> Stream.of(values)
                .map(value -> suit + " - " + value))
        .forEach(System.out::println);
    }
}