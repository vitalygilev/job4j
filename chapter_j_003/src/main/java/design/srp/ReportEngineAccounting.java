package design.srp;

import java.text.DecimalFormat;
import java.util.function.Predicate;

public class ReportEngineAccounting extends ReportEngine {

    public ReportEngineAccounting(Store store) {
        super(store);
    }

    /**
     * Generates Accountant-style report. Salary appearance changed to $###,###.### template.
     * @param filter Filter for data fetch.
     * @return String result. A report separated with ';'
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        DecimalFormat myFormatter = new DecimalFormat("$###,###.###");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(myFormatter.format(employee.getSalary())).append(";");
        }
        return text.toString();
    }
}
