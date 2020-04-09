package test.java.ru.job4j.array;

import org.junit.Test;
import ru.job4j.array.SimpleArray;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test
    public void whenAddGetFirstElement() {
        SimpleArray<Integer> elements = new SimpleArray<Integer>(2);
        elements.add(2);
        assertThat(elements.get(0), is(2));
    }

    @Test
    public void whenDeleteElement() {
        SimpleArray<String> elements = new SimpleArray<String>(2);
        elements.add("1");
        elements.add("2");
        elements.remove(0);
        assertThat(elements.get(0), is("2"));
    }

    @Test
    public void serialReading () {
        SimpleArray<Integer> elements = new SimpleArray<Integer>(2);
        elements.add(1);
        elements.add(2);
        assertThat(((Iterator<Integer>) elements).next(), is(1));
        assertThat(((Iterator<Integer>) elements).next(), is(2));
    }

}
