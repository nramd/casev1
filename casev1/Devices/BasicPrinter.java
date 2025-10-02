package casev1.Devices;

public class BasicPrinter implements Printable {
    @Override
    public void print(Document doc) {
        System.out.println("Printing document...");
    }
}