package design.srp;

import com.google.gson.Gson;

import java.util.List;

/**
 * Converts employees list to JSON form.
 */
public class ConverterJSON implements Converter {
    @Override
    public String convert(List<Employee> employees) {
        return new Gson().toJson(employees);
    }
}
