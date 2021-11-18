package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void process() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void convertDuplicate() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("001", "one"));
        orders.add(new Order("002", "two"));
        orders.add(new Order("001", "three"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(orders.size() - 1));
    }
}