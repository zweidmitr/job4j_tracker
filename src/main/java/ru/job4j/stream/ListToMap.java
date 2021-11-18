package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public Map<String, Student> fromListToMap(List<Student> students) {

        return students.stream()
                .collect(Collectors
                        .toMap(Student::getSurname,
                                element -> element,
                                (one, two) -> two
                ));
    }
}

