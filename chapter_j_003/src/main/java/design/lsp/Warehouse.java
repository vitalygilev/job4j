package design.lsp;

/**
 * Warehouse singleton object.
 */
public class Warehouse extends Storage implements Transfer {

    private static Warehouse instance = new Warehouse();

    private Warehouse() {
        super("Warehouse");
    }

    public static Warehouse getInstance() {
        return instance;
    }

    @Override
    public void move(StorageUnit currentFood) {
        currentFood.setStorage(instance);
    }
}
