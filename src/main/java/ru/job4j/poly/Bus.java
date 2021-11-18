package ru.job4j.poly;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Автобус ездит по скоростным трассам");

    }

    @Override
    public void open() {
        System.out.println("В автобус пассажиры заходят на остановках");
    }
}
