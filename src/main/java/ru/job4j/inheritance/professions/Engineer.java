package ru.job4j.inheritance.professions;

public class Engineer extends Profession {
    private boolean license;

    public Engineer(String name, String surname, String education, String birthday, boolean license) {
        super(name, surname, education, birthday);
        this.license = license;
    }
}
