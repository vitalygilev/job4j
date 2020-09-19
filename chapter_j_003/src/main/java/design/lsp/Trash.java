package design.lsp;

/**
 * Trash singleton object.
 */
public class Trash extends Storage implements Transfer {

    private static Trash  instance = new Trash();

    private Trash() {
        super("Trash");
    }

    public static Trash getInstance() {
        return instance;
    }

    @Override
    public void move(StorageUnit currentFood) {
        currentFood.setStorage(instance);
    }
}
