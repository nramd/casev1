package casev1.Devices;

public class AllInOnePrinter implements Printable, Scannable {
    @Override
    public void print(Document doc) {
        System.out.println("AIO: Printing document...");
    }
    @Override
    public void scan(Document doc) {
        System.out.println("AIO: Scanning document...");
    }
}