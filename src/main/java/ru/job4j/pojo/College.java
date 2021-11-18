package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Date date = new Date();
        Student studentik = new Student();
        studentik.setFio("Незнайка");
        studentik.setGroup("ЦветочныйГород");
        studentik.setDateP(date);

        System.out.println("Студент: " + studentik.getFio() + " from:  " + studentik.getGroup() + ", проснулся  " + studentik.getDateP());
    }
}
