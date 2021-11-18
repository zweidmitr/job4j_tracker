package ru.job4j.search;

public class Task {
    private String desc;
    private int priority;

    public Task(String desk, int priority) {
        this.desc = desk;
        this.priority = priority;
    }

    public String getDesk() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}