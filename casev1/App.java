package casev1;

import casev1.Devices.*;
import casev1.interfaces.*;
import casev1.Payment.*;
import casev1.Services.*;
import casev1.Student.*;
import casev1.Transport.*;

class InMemoryOrderManager implements OrderManager {
    private int stock = 100;

    public boolean isStockAvailable() {
        return stock > 0;
    }

    public void decreaseStock(int amount) {
        stock -= amount;
    }

    public int getCurrentStock() {
        return stock;
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("========== DEMO TICKET SERVICE ==========");

        // 1. Siapkan semua dependensi/layanan
        var manager = new InMemoryOrderManager();
        var studentRepo = new MySqlStudentRepository();
        var notifier = new EmailNotificationService();

        Student student1 = new Student("S123", "Budi");
        Student student2 = new Student("S456", "Ani");

        var gopayTicketService = new TicketService(
                manager, studentRepo, notifier, new GopayHandler());
        gopayTicketService.createOrder(student1, "budi@email.com", 75000);

        System.out.println("==========");

        var bniTicketService = new TicketService(
                manager, studentRepo, notifier, new BniVaHandler());
        bniTicketService.createOrder(student2, "ani@email.com", 75000);

        System.out.println("\n========== DEMO TRANSPORT (LSP) ==========");
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
