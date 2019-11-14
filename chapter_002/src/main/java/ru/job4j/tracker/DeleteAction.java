package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteAction extends BaseAction {

    public DeleteAction(int key) {
        super(key, "=== Delete item ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String itemId = input.askStr("Enter the Id of item to delete: ");
        if (!tracker.delete(itemId)) {
            //System.out.print("Wrong Id!");
            output.accept("Wrong Id!");
        }
        return true;
    }

}
