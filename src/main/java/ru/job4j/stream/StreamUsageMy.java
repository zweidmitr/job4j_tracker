package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsageMy {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {

        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);
        System.out.println("=======================");
        List<Task> container = new ArrayList<>();
        for (Task task : tasks) {
            if (task.name.contains("Bug")) {
                container.add(task);
            }
        }
        container.forEach(System.out::println);
        System.out.println("=======================");
        List<String> names = tasks.stream().map(
                task -> task.name
        ).collect(Collectors.toList());
        names.forEach(System.out::println);
        System.out.println("=======================");
        names.forEach(element -> System.out.print(element + ", "));
        System.out.println("\n=======================");
        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);
        System.out.println("total1: " + total);
        System.out.println("=======================");
        long totalTwo = 0L;
        for (Task task : tasks) {
            totalTwo += task.spent;
        }
        System.out.println("total2: " + totalTwo);
        System.out.println("=======================");
        List<Task> bugsTwo = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugsTwo.forEach(System.out::println);
        System.out.println("=======================");
        System.out.println("=======================");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(-1);
        numbers.add(2);
        numbers.add(-3);
        numbers.add(4);
        numbers.add(-5);
        List<Integer> filterNumbers = numbers.stream().filter(
                elem -> elem > 0
        ).collect(Collectors.toList());
        filterNumbers.forEach(System.out::println);

    }
}
