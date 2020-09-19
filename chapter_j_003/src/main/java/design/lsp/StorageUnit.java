package design.lsp;

/**
 * Class describes where exactly current Food is.
 */
public class StorageUnit {

    private Food food;
    private Storage storage;

    public StorageUnit(Food food, Storage storage) {
        this.food = food;
        this.storage = storage;
    }

    public Food getFood() {
        return food;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
