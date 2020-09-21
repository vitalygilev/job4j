package design.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Do quality control and distribute goods by storages
 */
class ControlQuality {

    private final Warehouse warehouse = new Warehouse();
    private final Shop shop = new Shop();
    private final Trash trash = new Trash();
    private final List<Storage> storages = new ArrayList<>();

    public ControlQuality() {
        storages.add(warehouse);
        storages.add(shop);
        storages.add(trash);
    }

    public List<Storage> getStorages() {
        return storages;
    }

    /**
     * Distributes goods by storages according to shelf life reminder.
     * @param controlDate Can be null. If so, distribution makes on current date.
     */
    public void distributeFood(Calendar controlDate, List<Food> balance) {
        if (controlDate == null) {
            controlDate = Calendar.getInstance();
        }
        for (Storage curStorage: storages) {
            for (Food curFood : balance) {
                if (curStorage.accept(curFood, controlDate)) {
                    curStorage.add(curFood);
                }
            }
        }
    }

}
