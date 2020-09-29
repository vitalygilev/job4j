package design.lsp.parking;

public class Parking implements Allocator {

    private final Vehicle[] cars;
    private final Vehicle[] trucks;
    int carsFreePlaces;
    int trucksFreePlaces;

    public Parking(int carsNumber, int trucksNumber) {
        cars = new Vehicle[carsNumber];
        trucks = new Vehicle[carsNumber];
        carsFreePlaces = carsNumber;
        trucksFreePlaces = trucksNumber;
    }

    boolean lookForFreePlace(Vehicle[] places, Vehicle vehicle, int size) {
        boolean result = false;
        int startPosition = 0;
        int serialFreePlacesCounter = 0;
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                if (serialFreePlacesCounter == 0) {
                    startPosition = i;
                }
                serialFreePlacesCounter++;
                if (serialFreePlacesCounter == size) {
                    for (int j = startPosition; j < startPosition + size; j++) {
                        places[j] = vehicle;
                    }
                    result = true;
                    break;
                }
            } else {
                serialFreePlacesCounter = 0;
            }
        }
        return result;
    }

    @Override
    public boolean accept(Vehicle vehicle) {
        boolean result = false;
        if (vehicle.getSize() > 1 && trucksFreePlaces > 0) {
            result = lookForFreePlace(trucks, vehicle, 1);
        }
        if (!result && carsFreePlaces > 0) {
            result = lookForFreePlace(cars, vehicle, vehicle.getSize());
            if (result) {
                carsFreePlaces += vehicle.getSize();
            }
        } else {
            trucksFreePlaces++;
        }
        return result;
    }

    Vehicle getTruck(int index) {
        Vehicle result = null;
        if (index < trucks.length) {
            result = trucks[index];
        }
        return result;
    }

    Vehicle getCar(int index) {
        Vehicle result = null;
        if (index < cars.length) {
            result = cars[index];
        }
        return result;
    }
}
