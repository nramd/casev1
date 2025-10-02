package casev1.Transport;

public class Car extends Vehicle implements Motorized {
    @Override
    public void turnOnEngine() {
        System.out.println("Car engine is ON.");
    }
    @Override
    public void move() {
        System.out.println("Driving car at " + currentSpeed + " km/h.");
    }
}