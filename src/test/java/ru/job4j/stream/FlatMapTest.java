package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FlatMapTest {

    @Test
    public void matrixToList() {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        FlatMap fm = new FlatMap();
        List<Integer> result = fm.matrixToList(matrix);
        List<Integer> expected = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        assertThat(result, is(expected));
    }
}