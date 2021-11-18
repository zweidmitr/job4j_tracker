package ru.job4j.poly;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий оракул, что ты хочешь узнать? ");
        String quest = input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                System.out.println("yes");
                break;
            case 1:
                System.out.println("no");
                break;
            case 2, 3:
                System.out.println("maybe");
            default:
                System.out.println("maybe");
        }

    }
}
