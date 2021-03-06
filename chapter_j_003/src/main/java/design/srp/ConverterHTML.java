package design.srp;

import java.util.List;

public class ConverterHTML implements Converter {

    @Override
    public String convert(List<Employee> employees) {
        StringBuilder text = new StringBuilder()
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
                .append("</tr>\n");
        for (Employee employee : employees) {
            text.append("<tr>\n")
                    .append("<td>").append(employee.getName()).append("</td>\n")
                    .append("<td>").append(employee.getHired()).append("</td>\n")
                    .append("<td>").append(employee.getFired()).append("</td>\n")
                    .append("<td>").append(employee.getSalary()).append("</td>\n")
                    .append("</tr>\n");
        }
        text.append("</table>\n")
                .append("</body>\n")
                .append("</html>\n");
        return text.toString();
    }
}
