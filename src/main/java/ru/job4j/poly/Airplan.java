package ru.job4j.poly;

public class Airplan implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летит по небу");
    }

    @Override
    public void open() {
        System.out.println("в Самолет пассажиры попадают только в аэропорту");
    }
}
