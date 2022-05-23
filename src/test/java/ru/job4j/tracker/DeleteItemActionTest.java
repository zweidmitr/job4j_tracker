package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteItemActionTest {

    @Test
    public void execute() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("deletedItem");
        tracker.add(item);
        int id = item.getId();
        DeleteItemAction del = new DeleteItemAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "=== Delete item ===" + ln + "Заявка успешно удалена." + ln));
        assertNull(tracker.findById(id));
    }
}