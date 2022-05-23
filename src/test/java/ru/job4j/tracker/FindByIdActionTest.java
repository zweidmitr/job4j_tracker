package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void execute() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("newItem");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "=== Find item by id ===" + ln + item + ln));
        assertThat(tracker.findAll().get(0).getName(), is("newItem"));
    }
}