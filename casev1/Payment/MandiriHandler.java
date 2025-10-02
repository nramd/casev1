package casev1.Payment;
import casev1.interfaces.PaymentHandler;

public class MandiriHandler implements PaymentHandler {
    @Override
    public boolean executePayment(double amount) {
        System.out.println("--> Processing " + amount + " via Mandiri Gateway.");
        return true;
    }
}