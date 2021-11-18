package ru.job4j.inheritance.professions;

public class Dentist extends Doctor {
    private boolean salary;

    public Dentist(String name,
                   String surname,
                   String education,
                   String birthday,
                   int age,
                   boolean salary) {
        super(name, surname, education, birthday, age);
        this.salary = salary;
    }

    public void bore() {

    }
}
