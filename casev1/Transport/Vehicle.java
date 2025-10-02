package casev1.Transport;

public abstract class Vehicle {
    protected int currentSpeed = 0;
    public void setSpeed(int speed) { this.currentSpeed = speed; }
    public abstract void move();
}

// Interface khusus untuk yang punya mesin
interface Motorized {
    void turnOnEngine();
}