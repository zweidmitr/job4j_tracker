package ru.job4j.inheritance;

public class ToyCat extends Cat {

    public boolean canBeWashByaWashMachine() {
        return true;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.canPurr());

        System.out.println();
        ToyCat toy = new ToyCat();
        System.out.println(toy.canPurr());
        System.out.println(toy.canBeWashByaWashMachine());
    }
}
