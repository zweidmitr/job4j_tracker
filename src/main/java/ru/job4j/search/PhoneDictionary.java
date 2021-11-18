package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> getSurname = p -> p.getSurname().contains(key);
        Predicate<Person> getPhone = p -> p.getPhone().contains(key);
        Predicate<Person> getAddress = p -> p.getAddress().contains(key);
        Predicate<Person> getName = p -> p.getName().contains(key);
        Predicate<Person> combine = p -> getSurname.or(getPhone).or(getAddress).or(getName).test(p);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
