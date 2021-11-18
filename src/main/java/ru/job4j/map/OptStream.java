package ru.job4j.map;

import ru.job4j.tracker.StubOutput;

import java.util.Optional;
import java.util.stream.Stream;

public class OptStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Optional<Integer> result = stream
                .filter(element -> element >= 5)
                .findFirst();
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Element not found");
        }
    }
}
