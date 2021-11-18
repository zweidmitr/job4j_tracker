package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double result = a.distance(b);
        double expected = 2.0;
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void distance3d() {
        Point a = new Point(2, 0, 7);
        Point b = new Point(0, 2, 3);
        double result = a.distance3d(b);
        double expected = 4.898;
        Assert.assertEquals(expected, result, 0.001);
    }
}