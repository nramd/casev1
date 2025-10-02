package casev1.interfaces;

public interface OrderManager {
    boolean isStockAvailable();
    void decreaseStock(int amount);
    int getCurrentStock();
}
