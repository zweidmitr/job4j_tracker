package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void execute() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = new Item("step one");
        Item two = new Item("step two");
        Item three = new Item("step three");

        tracker.add(one);
        tracker.add(two);
        tracker.add(three);

        FindByNameAction find = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(two.getName());
        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "=== Find by name ===" + ln + two + ln));
        assertThat(tracker.findAll().get(1), is(two));
    }
}