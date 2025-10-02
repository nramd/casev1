package casev1;
import casev1.Devices.*;
import casev1.interfaces.*;
import casev1.Payment.*;
import casev1.Services.*;
import casev1.Transport.*;


class InMemoryOrderManager implements OrderManager {
    private int stock = 100;
    public boolean isStockAvailable() { return stock > 0; }
    public void decreaseStock(int amount) { stock -= amount; }
    public int getCurrentStock() { return stock; }
}

class MySqlOrderRepository implements OrderRepository {
    public void save(String studentId, double amount) {
        System.out.println("--> Saving order for " + studentId + " to MySQL.");
    }
}

class EmailService implements MessageService {
    public void sendMessage(String recipient, String content) {
        System.out.println("--> Sending email to: " + recipient + " | Message: " + content);
    }
}


public class App {
    public static void main(String[] args) {
        System.out.println("--- DEMO TICKET SERVICE ---");

        var manager = new InMemoryOrderManager();
        var repository = new MySqlOrderRepository();
        var emailer = new EmailService();

        TicketService gopayTicketService = new TicketService(
            manager, repository, emailer, new GopayHandler()
        );
        gopayTicketService.createOrder("S123", "s123@email.com", 75000);

        System.out.println("---");

        TicketService bniTicketService = new TicketService(
            manager, repository, emailer, new BniVaHandler()
        );
        bniTicketService.createOrder("S456", "s456@email.com", 75000);

        System.out.println("\n--- DEMO TRANSPORT (LSP) ---");
        Vehicle myCar = new Car();
        myCar.setSpeed(60);
        ((Car) myCar).turnOnEngine(); 
        myCar.move();

        Vehicle myBike = new Bicycle();
        myBike.setSpeed(15);
        myBike.move();

        System.out.println("\n--- DEMO DEVICE (ISP) ---");
        Printable simplePrinter = new BasicPrinter();
        simplePrinter.print(new Document());
    }
}
