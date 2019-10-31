package ru.job4j.tracker;

public class EditAction extends BaseAction {

    public EditAction(int key) {
        super(key, "=== Edit item ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemId = input.askStr("Enter the Id of item to edit: ");
        Item currentItem = tracker.findById(itemId);
        if (currentItem != null) {
            String name = input.askStr("Enter new name: ");
            currentItem.setName(name);
            tracker.replace(itemId, currentItem);
        } else {
            System.out.print("Wrong Id!");
        }
        return true;
    }

}
