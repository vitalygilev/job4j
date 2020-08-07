package tracker;

import java.sql.SQLException;
import java.util.function.Consumer;

public interface UserAction {
    String info();
    boolean execute(Input input, Store tracker, Consumer<String> output) throws SQLException;
    int key();
}
