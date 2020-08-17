package tracker;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

public class FindItemsByNameAction extends BaseAction {

    public FindItemsByNameAction(int key) {
        super(key, "=== Find items by name ===");
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) throws SQLException {
        String itemName = input.askStr("Enter the Name of item to find: ");
        List<Item> foundItems = tracker.findByName(itemName);
        if (foundItems.size() != 0) {
            for (Item currentItem : foundItems) {
                //output.accept("Item: " + currentItem.getName() + " id = " + currentItem.getId());
                output.accept("Item: " + currentItem.getName());
            }
        } else {
            output.accept("Wrong Name!");
        }
        return true;
    }

}
