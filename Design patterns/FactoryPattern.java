interface Vehicle {
    void manufacture();
}

class Car implements Vehicle {
    @Override
    public void manufacture() {
        System.out.println("Manufacturing a Car");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void manufacture() {
        System.out.println("Manufacturing a Motorcycle");
    }
}

class VehicleFactory {

    public static Vehicle getVehicle(String type) {

        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("Motorcycle")) {
            return new Motorcycle();
        }

        return null;
    }
}

public class FactoryPattern {

    public static void main(String[] args) {

        Vehicle vehicle1 = VehicleFactory.getVehicle("Car");
        vehicle1.manufacture();

        Vehicle vehicle2 = VehicleFactory.getVehicle("Motorcycle");
        vehicle2.manufacture();
    }
}
