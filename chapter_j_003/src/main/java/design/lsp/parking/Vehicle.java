package design.lsp.parking;

public class Vehicle {
    private String name;
    private String idTag;
    private int size;

    public String getIdTag() {
        return idTag;
    }

    public Vehicle(String name, int size, String idTag) {
        this.name = name;
        this.size = size;
        this.idTag = idTag;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
