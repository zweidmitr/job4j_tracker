package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void upComparator() {
        Item item1 = new Item(005, "one");
        Item item2 = new Item(002, "two");
        Item item3 = new Item(010, "three");
        Item item4 = new Item(005, "four");
        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        Collections.sort(list, new ItemUpComparator());
        assertThat(list.get(list.size() - 1), is(item3));
    }

    @Test
    public void downComparator() {
        Item item1 = new Item(005, "one");
        Item item2 = new Item(002, "two");
        Item item3 = new Item(010, "three");
        Item item4 = new Item(002, "four");
        List<Item> list2 = new ArrayList<>();
        list2.add(item1);
        list2.add(item2);
        list2.add(item3);
        list2.add(item4);
        Collections.sort(list2, new ItemDownComparator());
        assertThat(list2.get(list2.size() - 1), is(item4));
    }
}