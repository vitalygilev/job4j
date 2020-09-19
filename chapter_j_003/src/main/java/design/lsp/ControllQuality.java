package design.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Do quality control and distribute goods by storages
 */
class ControlQuality {

    public List<StorageUnit> balance = new ArrayList<>();
    private final Warehouse warehouse = Warehouse.getInstance();
    private final Shop shop = Shop.getInstance();
    private final Trash trash = Trash.getInstance();

    /**
     * Distributes goods by storages according to shelf life reminder.
     * @param controlDate Can be null. If so, distribution makes on current date.
     */
    public void distributeFood(Calendar controlDate) {
        if (controlDate == null) {
            controlDate = Calendar.getInstance();
        }
        for (StorageUnit curFood : balance) {
            long shelLife = curFood.getFood().getExpireDate().getTimeInMillis() -
                                curFood.getFood().getCreateDate().getTimeInMillis();
            long shelLifeReminder = curFood.getFood().getExpireDate().getTimeInMillis() - controlDate.getTimeInMillis();
            if (shelLife == 0 ) {
                shelLife = shelLifeReminder;
            }
            float percentResult = (float) shelLifeReminder / shelLife;
            if (percentResult >= 0.75) {
                warehouse.move(curFood);
            } else if (percentResult >= 0.25 && percentResult < 0.75) {
                shop.move(curFood);
            } else {
                trash.move(curFood);
            }
        }
    }

}
