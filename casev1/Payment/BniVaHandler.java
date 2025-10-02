package casev1.Payment;
import casev1.interfaces.PaymentHandler;

public class BniVaHandler implements PaymentHandler {
    @Override
    public boolean executePayment(double amount) {
        System.out.println("--> Processing " + amount + " via BNI Virtual Account.");
        return true; // Asumsikan sukses
    }
}