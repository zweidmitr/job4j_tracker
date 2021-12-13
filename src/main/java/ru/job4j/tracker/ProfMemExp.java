package ru.job4j.tracker;

import java.util.concurrent.TimeUnit;

public class ProfMemExp {
    public static void main(String[] args) throws InterruptedException {
        MemTracker tracker = new MemTracker();
        TimeUnit.SECONDS.sleep(20);
        add(tracker);
        System.out.println("ups");
        TimeUnit.SECONDS.sleep(10);
        delete(tracker);

         System.out.println("done");
    }

    private static void add(MemTracker tracker) {
        for (int i = 0; i < 1_000_000; i++) {
            Item item = new Item("item " + i);
            tracker.add(item);
            System.out.println(i);
        }
    }

    private static void delete (MemTracker tracker) {
        for (int i = 0; i < 1_000_000; i++) {
            tracker.delete(i);
            System.out.println(i);
        }
    }
}
