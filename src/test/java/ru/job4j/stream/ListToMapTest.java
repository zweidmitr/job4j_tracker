package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void whenListLargerMap() {
        List<Student> students = new ArrayList<>();
        Student st1 = new Student(7, "Alex");
        Student st2 = new Student(5, "Dmitr");
        Student st3 = new Student(6, "Var");
        Student st4 = new Student(8, "Ksu");
        Student st5 = new Student(10, "Zwei");
        Student st6 = new Student(10, "Zwei");
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        ListToMap mapFrom = new ListToMap();
        Map<String, Student> result = mapFrom.fromListToMap(students);
        Map<String, Student> expected = new HashMap();
        expected.put("Alex", st1);
        expected.put("Dmitr", st2);
        expected.put("Var", st3);
        expected.put("Ksu", st4);
        expected.put("Zwei", st5);

        assertEquals(result, expected);
    }

    @Test
    public void fromListToMapKeySt() {
        List<Student> students = new ArrayList<>();
        Student st1 = new Student(7, "Alex");
        Student st2 = new Student(9, "Zwei");
        Student st3 = new Student(8, "Dmitr");
        students.add(st1);
        students.add(st2);
        students.add(st3);
        ListToMap mapFromL = new ListToMap();
        Student result = mapFromL.fromListToMap(students).get("Dmitr");
        assertThat(result, is(st3));
    }
}