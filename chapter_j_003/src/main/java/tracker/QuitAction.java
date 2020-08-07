package tracker;

import java.util.function.Consumer;

public class QuitAction extends BaseAction {

    public QuitAction(int key) {
        super(key, "=== Quit ===");
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        String itemId = input.askStr("Are you sure (y)? ");
        return !itemId.equals("y");
    }

}
