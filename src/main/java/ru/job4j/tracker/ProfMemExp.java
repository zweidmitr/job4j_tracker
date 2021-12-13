package ru.job4j.tracker;

public class ProfMemExp {
    public static void main(String[] args) {
        MemTracker tracker = new MemTracker();
        for (int i = 0; i < 1_000_000_000; i++) {
            Item item = new Item("item " + i);
            tracker.add(item);
            System.out.println(i);
        }
        System.out.println("done");
    }
}
