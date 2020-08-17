package tracker;

import java.sql.SQLException;
import java.util.function.Consumer;

public class CreateAction extends BaseAction {

    public CreateAction(int key) {
        super(key, "=== Create a new Item ====");
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) throws SQLException {
        String name = input.askStr("Enter name: ");
        String desc = input.askStr("Enter description: ");
        Item item = new Item(name, desc);
        tracker.add(item);
        return true;
    }

}
