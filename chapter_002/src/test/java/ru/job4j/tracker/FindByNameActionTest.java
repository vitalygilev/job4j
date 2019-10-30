package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindByNameActionTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

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
    public void whenCheckOutput() {
        Tracker tracker = new Tracker();
        Item item = new Item("bug fix");
        tracker.add(item);
        item = new Item("fix bug");
        tracker.add(item);
        tracker.add(item);
        FindItemsByNameAction act = new FindItemsByNameAction();
        act.execute(new StubInput(new String[] {"fix bug"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Enter the Name of item to find: " + "Item: " + item.getName() + " id = " + item.getId())
                .add("Item: " + item.getName() + " id = " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenCheckWrongName() {
        Tracker tracker = new Tracker();
        Item item = new Item("bug fix");
        tracker.add(item);
        item = new Item("fix bug");
        tracker.add(item);
        tracker.add(item);
        FindItemsByNameAction act = new FindItemsByNameAction();
        act.execute(new StubInput(new String[] {"crash firewall"}), tracker);
        String expect = "Enter the Name of item to find: Wrong Name!";
        assertThat(new String(out.toByteArray()), is(expect));
    }
}
