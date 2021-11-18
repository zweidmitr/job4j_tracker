package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobSorterTest {

    @Test
    public void jobDeskByNameTest() {
        List<Job> list = new ArrayList();
        list.add(new Job("one", 55));
        list.add(new Job("two", 99));
        list.add(new Job("eight", 42));
        list.add(new Job("six", 3));

        Collections.sort(list, new JobDeskByName());

        assertThat(list.get(0).getName(), is("two"));
    }

    @Test
    public void jobPlusByNameTest() {
        List<Job> list = new ArrayList();
        list.add(new Job("one", 55));
        list.add(new Job("two", 99));
        list.add(new Job("eight", 42));
        list.add(new Job("six", 3));

        Collections.sort(list, new JobPlusByName());

        assertThat(list.get(0).getName(), is("eight"));
    }

    @Test
    public void jobDeskByPriorityTest() {
        List<Job> list1 = new ArrayList();
        list1.add(new Job("one", 55));
        list1.add(new Job("two", 99));
        list1.add(new Job("eight", 42));
        list1.add(new Job("six", 3));

        Collections.sort(list1, new JobDeskByPriority());

        assertThat(list1.get(list1.size() - 1).getPriority(), is(3));
    }

    @Test
    public void jobPlusByPriorityTest() {
        List<Job> list1 = new ArrayList();
        list1.add(new Job("one", 55));
        list1.add(new Job("two", 99));
        list1.add(new Job("eight", 42));
        list1.add(new Job("six", 3));

        Collections.sort(list1, new JobPlusByPriority());

        assertThat(list1.get(list1.size() - 1).getPriority(), is(99));
    }

    @Test
    public void jobCombPriorityTest() {
        List<Job> list1 = new ArrayList();
        list1.add(new Job("one", 55));
        list1.add(new Job("two", 99));
        list1.add(new Job("eight", 42));
        list1.add(new Job("six", 3));
        list1.add(new Job("zero", 99));

        Collections.sort(list1, new JobPlusByPriority().thenComparing(new JobDeskByName()));

        assertThat(list1.get(list1.size() - 1).getName(), is("two"));
    }
}