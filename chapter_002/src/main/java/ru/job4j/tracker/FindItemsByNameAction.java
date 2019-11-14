package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindItemsByNameAction extends BaseAction {

    public FindItemsByNameAction(int key) {
        super(key, "=== Find items by name ===");
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String itemName = input.askStr("Enter the Name of item to find: ");
        List<Item> foundItems = tracker.findByName(itemName);
        if (foundItems.size() != 0) {
            for (Item currentItem : foundItems) {
                //System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
                output.accept("Item: " + currentItem.getName() + " id = " + currentItem.getId());
            }
        } else {
            //System.out.print("Wrong Name!");
            output.accept("Wrong Name!");
        }
        return true;
    }

}
