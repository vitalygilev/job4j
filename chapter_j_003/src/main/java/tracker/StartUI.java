package tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.function.Consumer;

public class StartUI {

    private final Input input;
    private final Store tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Store tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init(UserAction[] actions) throws SQLException {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu(actions);
            select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker, output);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Consumer<String> output = new Consumer<>() {
            private final PrintStream stdout = new PrintStream(out);

            @Override
            public void accept(String s) {
                stdout.println(s);
            }
        };
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction(0),
                    new ShowAllAction(1),
                    new EditAction(2),
                    new DeleteAction(3),
                    new FindItemByIdAction(4),
                    new FindItemsByNameAction(5),
                    new QuitAction(6)
            };
            new StartUI(validate, tracker, output).init(actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
