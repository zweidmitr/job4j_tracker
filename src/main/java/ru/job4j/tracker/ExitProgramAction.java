package ru.job4j.tracker;

public class ExitProgramAction implements UserAction {
    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
