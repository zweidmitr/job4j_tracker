package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UniqueTestTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        assertThat(UniqueTest.isEquals(origin, text), is(true));
    }

    @Test
    public void siNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten a cat";
        assertThat(UniqueTest.isEquals(origin, text), is(false));
    }
}