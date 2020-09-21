package design.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Warehouse object.
 */
public class Shop implements Storage {

    private final String name = "Shop";
    private List<Food> goods = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void add(Food food) {
        goods.add(food);
    }

    @Override
    public boolean accept(Food food, Calendar controlDate) {
        long shelLife = food.getExpireDate().getTimeInMillis() -
                food.getCreateDate().getTimeInMillis();
        long shelLifeReminder = food.getExpireDate().getTimeInMillis() - controlDate.getTimeInMillis();
        if (shelLife == 0 ) {
            shelLife = shelLifeReminder;
        }
        float percentResult = (float) shelLifeReminder / shelLife;
        return  (percentResult >= 0.25 && percentResult < 0.75);
    }

    @Override
    public List<Food> clear() {
        List<Food> result = new ArrayList<>(goods);
        goods.clear();
        return result;
    }
}
