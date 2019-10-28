package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter the Id of item to delete: ");
        String itemId = input.askStr("");
        if (!tracker.delete(itemId)) {
            System.out.print("Wrong Id!");
        }
        return true;
    }

}
