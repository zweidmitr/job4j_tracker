package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int fact = calc(3);
    }
}
