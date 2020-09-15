package design.srp;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConverterJSONTest {
    @Test
    public void whenJSONConversion() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan", null, null, 100);
        store.add(worker);
        StringBuilder expect = new StringBuilder()
                .append("[{\"name\":\"Ivan\",\"salary\":100.0}]");
        assertThat(new ConverterJSON().convert(store.findBy(em -> true)), is(expect.toString()));
    }
}