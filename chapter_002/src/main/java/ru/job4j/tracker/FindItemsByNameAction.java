package ru.job4j.tracker;

public class FindItemsByNameAction extends BaseAction {

    public FindItemsByNameAction(int key) {
        super(key, "=== Find items by name ===");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter the Name of item to find: ");
        Item[] foundItems = tracker.findByName(itemName);
        if (foundItems.length != 0) {
            for (Item currentItem : tracker.findByName(itemName)) {
                System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
            }
        } else {
            System.out.print("Wrong Name!");
        }
        return true;
    }

}
