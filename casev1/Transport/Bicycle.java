package casev1.Transport;

public class Bicycle extends Vehicle {
    @Override
    public void move() {
        System.out.println("Cycling at " + currentSpeed + " km/h.");
    }
}