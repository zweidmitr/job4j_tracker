package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageData {
    public static void main(String[] args) {
        LocalDate currentData = LocalDate.now();
        System.out.println("Текущая дата: " + currentData);

        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущее время: " + currentTime);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущие дата и время, до форматирования: " + currentDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDataTimeFormat = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время, после форматирования: " + currentDataTimeFormat);
    }
}
