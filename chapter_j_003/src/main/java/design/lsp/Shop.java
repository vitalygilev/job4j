package design.lsp;

/**
 * Shop singleton object.
 */
public class Shop extends Storage implements Transfer {

    private static Shop instance = new Shop();

    private Shop() {
        super("Shop");
    }

    public static Shop getInstance() {
        return instance;
    }

    @Override
    public void move(StorageUnit currentFood) {
        currentFood.setStorage(instance);
    }
}
