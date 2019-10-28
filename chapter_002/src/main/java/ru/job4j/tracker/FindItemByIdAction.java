package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter the Id of item to find: ");
        String itemId = input.askStr("");
        Item currentItem = tracker.findById(itemId);
        if (currentItem != null) {
            System.out.print("Found by Id: " + currentItem.getName());
        } else {
            System.out.print("Wrong Id!");
        }
        return true;
    }

}
