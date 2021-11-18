package ru.job4j.tracker;

import org.junit.Test;

import java.lang.annotation.Native;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("15", "1", "0"));
        Tracker tracker = new Tracker();
        List<UserAction> action = new ArrayList<>();
        action.add(new ShowAllItemAction(out));
        action.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu: " + ln
                        + "0. Show all item" + ln
                        + "1. Exit program" + ln
                        + "Wrong input!! You can select: 0 .. 0" + ln
                        + "Menu: " + ln
                        + "0. Show all item" + ln
                        + "1. Exit program" + ln
                )
        );

    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator() + "0. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllNull() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0", "1"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItemAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Show all item" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "Хранилище еще не содержит заявок" + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Show all item" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllOneItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testik"));
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0", "1"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItemAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Show all item" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Show all item" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testik"));
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0", String.valueOf(item.getName()), "1"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "=== Find by name ===" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testik"));
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0", String.valueOf(item.getId()), "1"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "=== Find item by id ===" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0", "testItem", "1"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("testItem"));

    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "new Item Name";
        Input in = new StubInput(List.of("0", String.valueOf(item.getId()), replacedName, "1"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceItemAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(List.of("0", String.valueOf(item.getId()), "1"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItemAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}