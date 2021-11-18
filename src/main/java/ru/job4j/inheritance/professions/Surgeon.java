package ru.job4j.inheritance.professions;

public class Surgeon extends Doctor {
    private boolean experience;

    public Surgeon(String name, String surname, String education, String birthday, int age, boolean experience) {
        super(name, surname, education, birthday, age);
        this.experience = experience;
    }

    public void cut() {

    }
}
