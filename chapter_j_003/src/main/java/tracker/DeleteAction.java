package tracker;

import java.sql.SQLException;
import java.util.function.Consumer;

public class DeleteAction extends BaseAction {

    public DeleteAction(int key) {
        super(key, "=== Delete item ====");
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) throws SQLException {
        String itemId = input.askStr("Enter the Id of item to delete: ");
        if (!tracker.delete(itemId)) {
            //System.out.print("Wrong Id!");
            output.accept("Wrong Id!");
        }
        return true;
    }

}
