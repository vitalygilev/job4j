package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter the Name of item to find: ");
        String itemName = input.askStr("");
        Item[] foundItems = tracker.findByName(itemName);
        if (foundItems.length != 0) {
            for (Item currentItem : foundItems) {
                if (currentItem != null) {
                    System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
                }
            }
        } else {
            System.out.print("Wrong Name!");
        }
        return true;
    }

}
