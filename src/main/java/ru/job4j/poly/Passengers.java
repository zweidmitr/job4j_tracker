package ru.job4j.poly;

public class Passengers {
    public static void main(String[] args) {
        Vehicle airplan1 = new Airplan();
        Vehicle bus1 = new Bus();
        Vehicle train1 = new Train();

        Vehicle airplan0 = new Airplan();
        Vehicle bus0 = new Bus();
        Vehicle train0 = new Train();

        Vehicle[] array = new Vehicle[6];
        array[0] = airplan0;
        array[1] = bus0;
        array[2] = train0;
        array[3] = airplan1;
        array[4] = bus1;
        array[5] = train1;

        for (Vehicle transport : array) {
            transport.move();
            transport.open();
            System.out.println();
        }

    }
}
