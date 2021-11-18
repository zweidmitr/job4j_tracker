package ru.job4j.inheritance.professions;

public class Programmer extends Engineer {
    private boolean java;

    public Programmer(String name,
                      String surname,
                      String education,
                      String birthday,
                      boolean license,
                      boolean java) {
        super(name, surname, education, birthday, license);
        this.java = java;
    }

    public void code() {

    }
}
