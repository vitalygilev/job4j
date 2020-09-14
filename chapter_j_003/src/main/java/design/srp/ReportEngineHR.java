package design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHR extends ReportEngine {

    public ReportEngineHR(Store store) {
        super(store);
    }

    /**
     * Generates HR-style report. Employees sorted by salary. Hired and Fired dates removed.
     * @param filter Filter for data fetch.
     * @return String result. A report separated with ';'
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        List<Employee> result = store.findBy(filter);
        result.sort((Comparator) (o1, o2) -> (int) (((Employee)o2).getSalary() - ((Employee)o1).getSalary()));
        for (Employee employee : result) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }

}
