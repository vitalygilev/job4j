package design.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Functional interface for data fetch.
 */
public interface Store {

    List<Employee> findBy(Predicate<Employee> filter);
}