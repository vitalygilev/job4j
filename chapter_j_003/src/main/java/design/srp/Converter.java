package design.srp;

import java.util.List;

/**
 * Interface of extension SRP to OCP (all hail to Robocop!)
 */
public interface Converter {

    String convert(List<Employee> employees);
}
