package design.srp;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConverterXMLTest {
    @Test
    public void whenXMLConversion() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan", null, null, 100);
        store.add(worker);
        StringBuilder expect = new StringBuilder()
                .append("<list>\n")
                .append("  <design.srp.Employee>\n")
                .append("    <name>Ivan</name>\n")
                .append("    <salary>100.0</salary>\n")
                .append("  </design.srp.Employee>\n")
                .append("</list>");
        assertThat(new ConverterXML().convert(store.findBy(em -> true)), is(expect.toString()));
    }

}