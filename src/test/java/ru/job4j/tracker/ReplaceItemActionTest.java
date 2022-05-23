package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReplaceItemActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("ReplacedItem"));
        String replacedItem = "newRepItem";
        ReplaceItemAction rep = new ReplaceItemAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedItem);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "=== Edit item ===" + ln + "Заяка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedItem));
    }
}