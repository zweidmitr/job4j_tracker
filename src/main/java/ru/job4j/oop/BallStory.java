package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Fox fox = new Fox();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();

        kolobok.run();
        hare.tryEat(kolobok);
        kolobok.run();
        wolf.tryEat(kolobok);
        kolobok.run();
        fox.tryEat(kolobok);
        fox.eat(kolobok);
    }
}