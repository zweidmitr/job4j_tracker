package ru.job4j.inheritance.professions;

public class Builder extends Engineer {
    private int employees;

    public Builder(String name, String surname, String education, String birthday, boolean license, int employees) {
        super(name, surname, education, birthday, license);
        this.employees = employees;
    }

    public void build() {

    }
}
