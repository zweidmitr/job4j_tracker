package ru.job4j.poly;

public class NewBus implements Transport {
    @Override
    public void drive() {
        System.out.println("Этот новый автобус и ездит он по новым дорогам");
    }

    @Override
    public void passengers(int pass) {
        System.out.println("а пассажиры в новом автобусе чаще улыбаются");

    }

    @Override
    public double tankUp(int fuel) {
        System.out.println("НовыйАвтобус принимает количество литров, "
                        +  "умножает на цену бензина и возвращает стоимоть текущей заправки");
        return fuel * 25;
    }
}
