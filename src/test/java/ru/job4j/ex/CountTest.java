package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThanFinish() {
        Count.add(10, 2);
    }
}