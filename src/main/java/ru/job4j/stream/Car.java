package ru.job4j.stream;

public class Car {
    private String model;
    private String color;
    private byte countDoor;
    private int horsePower;
    private boolean electroCar;

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", color='" + color + '\''
                + ", countDoor=" + countDoor
                + ", horsePower=" + horsePower
                + ", electroCar=" + electroCar
                + '}';
    }

    static class Builder {
        private String model;
        private String color;
        private byte countDoor;
        private int horsePower;
        private boolean electroCar;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildCountDoor(byte countDoor) {
            this.countDoor = countDoor;
            return this;
        }

        Builder buildHorsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        Builder buildElectroCar(boolean electroCar) {
            this.electroCar = electroCar;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.model = model;
            car.color = color;
            car.countDoor = countDoor;
            car.horsePower = horsePower;
            car.electroCar = electroCar;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildModel("Tesla")
                .buildColor("white")
                .buildCountDoor((byte) 5)
                .buildHorsePower(800)
                .buildElectroCar(true)
                .build();
        System.out.println(car);
    }
}
