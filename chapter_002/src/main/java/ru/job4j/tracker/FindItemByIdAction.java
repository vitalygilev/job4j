package ru.job4j.tracker;

public class FindItemByIdAction extends BaseAction {

    public FindItemByIdAction(int key) {
        super(key, "=== Find item by Id ===");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemId = input.askStr("Enter the Id of item to find: ");
        Item currentItem = tracker.findById(itemId);
        if (currentItem != null) {
            System.out.print("Found by Id: " + currentItem.getName());
        } else {
            System.out.print("Wrong Id!");
        }
        return true;
    }

}
