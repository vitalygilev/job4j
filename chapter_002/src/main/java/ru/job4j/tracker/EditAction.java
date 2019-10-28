package ru.job4j.tracker;

public class EditAction implements UserAction {

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter the Id of item to edit: ");
        String itemId = input.askStr("");
        Item currentItem = tracker.findById(itemId);
        if (currentItem != null) {
            System.out.print("Enter new name: ");
            String name = input.askStr("");
            currentItem.setName(name);
            tracker.replace(itemId, currentItem);
        } else {
            System.out.print("Wrong Id!");
        }
        return true;
    }

}
