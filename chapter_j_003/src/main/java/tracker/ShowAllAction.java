package tracker;

import java.sql.SQLException;
import java.util.function.Consumer;

public class ShowAllAction extends BaseAction {

    public ShowAllAction(int key) {
       super(key, "=== Show all items ====");
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) throws SQLException {
        for (Item currentItem : tracker.findAll()) {
            output.accept("Item: " + currentItem.getName() + " id = " + currentItem.getId());
        }
        return true;
    }

}
