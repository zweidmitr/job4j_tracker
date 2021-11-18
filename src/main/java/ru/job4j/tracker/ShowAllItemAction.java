package ru.job4j.tracker;

import java.util.List;

public class ShowAllItemAction implements UserAction {
    private final Output out;

    public ShowAllItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
