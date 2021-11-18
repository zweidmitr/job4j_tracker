package ru.job4j.inheritance.professions;

public class Doctor extends Profession {
    private int age;

    public Doctor(String name, String surname, String education, String birthday, int age) {
        super(name, surname, education, birthday);
        this.age = age;
    }

    public Diagnosis heal(Pacient pacient) {
        Diagnosis allIsGood = new Diagnosis();
        return allIsGood;
    }
}
