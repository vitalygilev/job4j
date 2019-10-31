package ru.job4j.tracker;

public interface UserAction {
    String info();
    boolean execute(Input input, Tracker tracker);
    int key();
}
