package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> newMap = new HashMap<>();
        for (Order order : orders) {
            newMap.put(order.getNumber(), order);
        }
        return newMap;
    }
}
