package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAddAndFindAll() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("testItem");
        tracker.add(item);
        List<Item> result = tracker.findAll();
        assertEquals(item, result.get(0));
    }

    @Test
    public void replace() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("NameItem");
        Item itemTest = new Item("testItem");
        Item itemTestTwo = new Item("superItem");
        tracker.add(item);
        tracker.add(itemTest);
        tracker.replace(1, itemTestTwo);

        List<Item> result = tracker.findByName("superItem");
        assertEquals(result.get(0).getName(), "superItem");
    }

    @Test
    public void delete() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("NameItem");
        Item itemTest = new Item("testItem");
        Item itemTestTwo = new Item("superItem");
        tracker.add(itemTest);
        tracker.add(item);
        tracker.add(itemTestTwo);
        tracker.delete(3);
        List<Item> result = tracker.findAll();
        assertEquals(result.size(), 2);
    }

    @Test
    public void findByName() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("NameItem");
        Item itemTest = new Item("testItem");
        tracker.add(itemTest);
        tracker.add(item);
        List<Item> result = tracker.findByName("NameItem");
        assertEquals(item, result.get(0));
    }

    @Test
    public void findById() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("NameItem");
        Item itemTest = new Item("testItem");
        Item itemTestTwo = new Item("superItem");
        tracker.add(itemTest);
        tracker.add(item);
        tracker.add(itemTestTwo);
        Item result = tracker.findById(3);
        assertEquals(itemTestTwo, result);
    }
}