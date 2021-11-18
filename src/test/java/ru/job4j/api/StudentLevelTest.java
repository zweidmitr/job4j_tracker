package ru.job4j.api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(new Student("Petya", 118));
        List<Student> expected = List.of(
                new Student("Petya", 118),
                new Student("Masha", 28)
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(null);
        List<Student> expected = List.of(
                new Student("Masha", 28)
        );
        assertThat(StudentLevel.levelOf(input, 10), is(expected));

    }

}