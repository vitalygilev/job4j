package design.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {

    @Test
    public void when2TrucksAnd2Cars() {
        Truck truck1 = new Truck("Kamaz",3, "a111aa11");
        Truck truck2 = new Truck("Gazelle",3, "a112aa11");
        Car car1 = new Car("UAZ", "a113aa11");
        Car car2 = new Car("VAZ", "a114aa11");
        Parking parking = new Parking(2, 2);
        parking.accept(truck1);
        parking.accept(truck2);
        parking.accept(car1);
        parking.accept(car2);
        StringBuilder generated = new StringBuilder();
        generated.append(truck1.getIdTag());
        generated.append(car2.getIdTag());
        StringBuilder expect = new StringBuilder();
        expect.append(parking.getTruck(0).getIdTag());
        expect.append(parking.getCar(1).getIdTag());
        assertThat(generated.toString(), is(expect.toString()));
    }

    @Test
    public void whenThereIsNoPlace() {
        Truck truck1 = new Truck("Kamaz",3, "a111aa11");
        Truck truck2 = new Truck("Gazelle",3, "a112aa11");
        Parking parking = new Parking(1, 1);
        parking.accept(truck1);
        boolean generated = parking.accept(truck2);
        assertThat(generated, is(false));
    }
}