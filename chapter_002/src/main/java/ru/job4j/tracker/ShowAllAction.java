package ru.job4j.tracker;

public class ShowAllAction extends BaseAction {

    public ShowAllAction(int key) {
       super(key, "=== Show all items ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item currentItem : tracker.findAll()) {
            System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
        }
        return true;
    }

}
