package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Появилась ошибка: " + active);
        System.out.println("Номер ошибки " + status);
        System.out.println("Сообщение пользователю: " + message);
    }

    public static void main(String[] args) {
        Error crit = new Error();
        crit.printInfo();
        System.out.println();
        Error easy = new Error(true, 77, "перезагрузите ПК");
        easy.printInfo();
        System.out.println();
        Error hard = new Error(true, 1, "Вы действительно хотите удалить диск с:");
        hard.printInfo();
    }

}