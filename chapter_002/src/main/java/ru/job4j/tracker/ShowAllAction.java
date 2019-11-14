package ru.job4j.tracker;

import java.util.function.Consumer;

public class ShowAllAction extends BaseAction {

    public ShowAllAction(int key) {
       super(key, "=== Show all items ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        for (Item currentItem : tracker.findAll()) {
            //System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
            output.accept("Item: " + currentItem.getName() + " id = " + currentItem.getId());
        }
        return true;
    }

}
