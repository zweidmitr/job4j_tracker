package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд ездит по рельсам");
    }

    @Override
    public void open() {
        System.out.println("В поезд люди садятся на вокзале");
    }
}
