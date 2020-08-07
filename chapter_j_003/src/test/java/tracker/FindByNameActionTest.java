package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByNameActionTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenCheckOutput() throws SQLException {
        Store tracker = new SqlTracker();
        Item item = new Item("bug fix");
        tracker.add(item);
        item = new Item("fix bug");
        tracker.add(item);
        tracker.add(item);
        FindItemsByNameAction act = new FindItemsByNameAction(0);
        act.execute(new StubInput(new String[] {"fix bug"}), tracker, output);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Item: " + item.getName() + " id = " + item.getId())
                .add("Item: " + item.getName() + " id = " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenCheckWrongName() throws SQLException {
        Store tracker = new SqlTracker();
        Item item = new Item("bug fix");
        tracker.add(item);
        item = new Item("fix bug");
        tracker.add(item);
        tracker.add(item);
        FindItemsByNameAction act = new FindItemsByNameAction(0);
        act.execute(new StubInput(new String[] {"crash firewall"}), tracker, output);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Wrong Name!")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }
}
