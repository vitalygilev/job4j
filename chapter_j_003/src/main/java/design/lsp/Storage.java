package design.lsp;

import java.util.Calendar;
import java.util.List;

public interface Storage {

    String getName();
    void add(Food food);
    boolean accept(Food food, Calendar controlDate);
    List<Food> clear();

}
