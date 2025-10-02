package casev1.Services;
import casev1.interfaces.*;

public class TicketService {
    private final OrderManager orderManager;
    private final OrderRepository orderRepository;
    private final MessageService messageService;
    private final PaymentHandler paymentHandler;

    // Dependensi "disuntikkan" (Dependency Injection) melalui constructor
    public TicketService(OrderManager manager, OrderRepository repo, MessageService msg, PaymentHandler payment) {
        this.orderManager = manager;
        this.orderRepository = repo;
        this.messageService = msg;
        this.paymentHandler = payment;
    }

    public void createOrder(String studentId, String email, double price) {
        if (!orderManager.isStockAvailable()) {
            System.out.println("Order failed: Ticket is sold out.");
            return;
        }

        System.out.println("Processing order for student: " + studentId);
        boolean isPaid = paymentHandler.executePayment(price);

        if (isPaid) {
            orderRepository.save(studentId, price);
            orderManager.decreaseStock(1);
            messageService.sendMessage(email, "Your payment of " + price + " was successful!");
            System.out.println("Order completed. Remaining stock: " + orderManager.getCurrentStock());
        } else {
            System.out.println("Order failed: Payment was not successful.");
        }
    }
}
