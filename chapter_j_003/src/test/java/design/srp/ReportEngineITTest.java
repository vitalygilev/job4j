package design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineITTest {

    @Test
    public void whenITGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngineIT engine = new ReportEngineIT(store);
        StringBuilder expect = new StringBuilder()
                .append("<html>\n")
                .append("<head>\n")
                .append("<title>HTML</title>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<table>\n")
                .append("<tr>\\n")
                .append("<th>Name</th>\n")
                .append("<th>Hired</th>\n")
                .append("<th>Fired</th>\n")
                .append("<th>Salary</th>\n")
                .append("</tr>\n")
                .append("<tr>\n")
                .append("<td>").append(worker.getName()).append("</td>\n")
                .append("<td>").append(worker.getHired()).append("</td>\n")
                .append("<td>").append(worker.getFired()).append("</td>\n")
                .append("<td>").append(worker.getSalary()).append("</td>\n")
                .append("</tr>\n")
                .append("</table>\n")
                .append("</body>\n")
                .append("</html>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}