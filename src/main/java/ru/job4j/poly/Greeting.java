package ru.job4j.poly;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Добро пожаловать. Как вас зовут? ");
        String name = input.nextLine();
        System.out.println(name + ", рад вас видеть");
    }
}
