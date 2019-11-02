package ru.job4j.tracker;

public enum  TrackerSingletonEnumEager {
    INSTANCE;
    public Item add(Item model) {
        return model;
    }
}
