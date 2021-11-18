package ru.job4j.collection;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConvertList2ArrayTest {

    @Test
    public void when7elementsThen9() {
        int[][] result = ConvertList2Array.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7), 3
        );
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };

        assertThat(result, is(expected));
    }
}