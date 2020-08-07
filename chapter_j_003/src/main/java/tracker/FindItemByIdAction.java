package tracker;

import java.sql.SQLException;
import java.util.function.Consumer;

public class FindItemByIdAction extends BaseAction {

    public FindItemByIdAction(int key) {
        super(key, "=== Find item by Id ===");
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) throws SQLException {
        String itemId = input.askStr("Enter the Id of item to find: ");
        Item currentItem = tracker.findById(itemId);
        if (currentItem != null) {
            output.accept("Found by Id: " + currentItem.getName());
        } else {
            output.accept("Wrong Id!");
        }
        return true;
    }

}
