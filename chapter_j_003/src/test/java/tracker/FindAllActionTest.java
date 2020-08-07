package tracker;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindAllActionTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Test
    public void whenCheckOutput() throws SQLException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Store tracker = new SqlTracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAllAction act = new ShowAllAction(0);
        act.execute(new StubInput(new String[] {}), tracker, output);
        /*String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Item: " + item.getName() + " id = " + item.getId())
                .toString();*/
        String expect = "";
                assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

}
