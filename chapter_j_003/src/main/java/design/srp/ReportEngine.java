package design.srp;

import java.util.function.Predicate;

/**
 * Basic report class.
 */
public class ReportEngine {

    protected Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    /**
     * Generates a report text.
     * @param filter Filter for data fetch.
     * @return String result. A report separated with ';'
     */
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}