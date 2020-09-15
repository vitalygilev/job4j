package design.srp;

import com.thoughtworks.xstream.XStream;

import java.util.List;

/**
 * Converts employees list to XML form.
 */
public class ConverterXML implements Converter {
    @Override
    public String convert(List<Employee> employees) {
        XStream xstream = new XStream();
        return xstream.toXML(employees);
    }
}
