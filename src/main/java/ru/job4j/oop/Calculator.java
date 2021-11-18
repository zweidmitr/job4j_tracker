package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int a) {
        return x - a;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        return add(first, add(second, third));
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        int res = Calculator.minus(2);
        System.out.println(res);
        Calculator calc = new Calculator();
        int rsl = calc.multiply(5);
        System.out.println(rsl);
        rsl = calc.divide(25);
        System.out.println(rsl);
        int bigResult = calc.sumAllOperation(10);
        System.out.println();
        System.out.println(bigResult);
    }
}