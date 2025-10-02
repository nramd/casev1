package casev1.Services;
import casev1.interfaces.*;
import casev1.Student.Student;

public class TicketService {
    private final OrderManager orderManager;
    private final StudentRepository studentRepository;
    private final NotificationService notificationService;
    private final PaymentHandler paymentHandler;

    public TicketService(OrderManager manager, StudentRepository repo, NotificationService notifier, PaymentHandler payment) {
        this.orderManager = manager;
        this.studentRepository = repo;
        this.notificationService = notifier;
        this.paymentHandler = payment;
    }

    public void createOrder(Student student, String email, double price) {
        if (!orderManager.isStockAvailable()) {
            System.out.println("Order failed: Ticket is sold out.");
            return;
        }

        if (!studentRepository.studentExists(student.getId())) {
             System.out.println("Validation failed: Student not found.");
             return;
        }
        
        System.out.println("Processing order for student: " + student.getName());
        boolean isPaid = paymentHandler.executePayment(price);

        if (isPaid) {
            studentRepository.saveOrder(student, price);
            orderManager.decreaseStock(1);
            notificationService.sendNotification(email, "Your payment of " + price + " for ticket was successful!");
            System.out.println("Order completed. Remaining stock: " + orderManager.getCurrentStock());
        } else {
            System.out.println("Order failed: Payment was not successful.");
        }
    }
}