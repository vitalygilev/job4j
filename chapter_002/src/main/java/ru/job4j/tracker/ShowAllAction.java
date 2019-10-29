package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        for (Item currentItem : allItems) {
            System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
        }
        return true;
    }

}
