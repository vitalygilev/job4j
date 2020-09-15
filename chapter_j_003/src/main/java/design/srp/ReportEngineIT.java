package design.srp;

import java.util.function.Predicate;

public class ReportEngineIT extends ReportEngine {

    public ReportEngineIT(Store store) {
        super(store);
    }

    /**
     * Generates IT-style report. Result generates in HTML code.
     * @param filter Filter for data fetch.
     * @return String result in HTML code.
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        return new ConverterHTML().convert(this.store.findBy(filter));
    }
}
