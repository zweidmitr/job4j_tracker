package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String Interface";
        Consumer<String> consumer = (s0) -> System.out.println(s0);
        consumer.accept(sup.get());
        System.out.println("--------------------------");

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supp = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumerBi = (s1, s2) -> System.out.println(s1 + s2);
        Set<String> strings = supp.get();
        int i = 1;
        for (String s1 : strings) {
            consumerBi.accept(i++, " is " + s1);
            System.out.println("--------------------------");
        }

        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));
        System.out.println("--------------------------");

        BiPredicate<String, Integer> cond = (s, in) -> s.contains(in.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("name", 123));
        System.out.println("--------------------------");

        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));
        System.out.println("--------------------------");

        BiFunction<String, Integer, String> biFunc = (s, in) -> s.concat(" ").concat(in.toString());
        System.out.println("Результат работы биФункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы биФункции: " + biFunc.apply("String number", 12345));
        System.out.println("--------------------------");

        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(
                new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(
                new StringBuilder("tset rof gnirtS")));
        System.out.println("--------------------------");

        BinaryOperator<StringBuilder> sb = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println("Строка после объединения " + sb.apply(
                new StringBuilder("First string"),
                new StringBuilder("Second String")
        ));
    }

}
