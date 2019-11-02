package ru.job4j.tracker;

public class TrackerSingletonStaticFinalFieldEager {

    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingletonStaticFinalFieldEager() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
