package ru.job4j.tracker;

public class TrackerSingletonStaticFieldLazy {

    private static Tracker instance;

    private TrackerSingletonStaticFieldLazy() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
    public Item add(Item model) {
        return model;
    }
}
