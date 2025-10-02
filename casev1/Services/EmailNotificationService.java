package casev1.Services;
import casev1.interfaces.NotificationService;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("--> Sending email notification to: " + recipient);
        System.out.println("    Message: " + message);
    }
}
