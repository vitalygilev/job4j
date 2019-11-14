package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindItemByIdAction extends BaseAction {

    public FindItemByIdAction(int key) {
        super(key, "=== Find item by Id ===");
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String itemId = input.askStr("Enter the Id of item to find: ");
        Item currentItem = tracker.findById(itemId);
        if (currentItem != null) {
            //System.out.print("Found by Id: " + currentItem.getName());
            output.accept("Found by Id: " + currentItem.getName());
        } else {
            //System.out.print("Wrong Id!");
            output.accept("Wrong Id!");
        }
        return true;
    }

}
