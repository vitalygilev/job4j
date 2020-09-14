package design.srp;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineHRTest {
    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 111);
        Employee worker2 = new Employee("Petr", now, now, 222);
        Employee worker3 = new Employee("Fyodor", now, now, 333);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportEngineHR engine = new ReportEngineHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}