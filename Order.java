
public class Order {

    private int orderId;
    private double total;
    private LocalDate date;
    private List<OrderItem> items;
    private String status //pending, delivered, shipped
    private LocalDate expectedArrival; //five days after placing

    public Order(int orderId, double total, LocalDate date) {
        this.orderId = orderId;
        this.total = total;
        this.date = date;
        items = new ArrayList<>();
        this.expectedArrival = date.plusDays(5);

    }

    public Order(int orderId, double total, LocalDate date, String status) {
        this.orderId = orderId;
        this.total = total;
        this.date = date;
        items = new ArrayList<>();
        this.status = status;
        this.expectedArrival = date.plusDays(5);

    }

    public double getPurchaseTotal() {
        double total = 0;
        for (OrderItem item : items) {
            double+=item.getCost() * item.getQuantity();
        }
        this.total = total;
        return total;
    }

    public Localdate getDate() {
        return date;
    }

    public int getId() {
        return orderId;
    }

    public void addItem(Item item, int qty) {
        OrderItem newItem = new OrderItem(qty, item, item.getPrice());
        items.add(newItem);

    }

    public List<OrderItem> getOrderItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus() {
        LocalDate targetDate = date.plusDays(1);
        if (LocalDate.now().isAfter(targetDate)) {
            this.status = "Shipped";
        } else if (LocalDate.now().isAfter(expectedArrival)) {
            this.status = "Delivered";
        } else {
            this.status = "Pending";
        }
    }

    public String toString() {
        String result = "Order ID: " + orderId + " Order Total: " + total + " Items: ";
        for (int i = 0; i < items.size(); i++) {
            result += items.get(i).getName();
            result += " ";
        }
        return result;
    }

}
