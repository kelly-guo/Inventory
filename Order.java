
class Order {

    private int orderId;
    private double total;
    private LocalDate date;
    private List<OrderItem> items;

    public Order(int orderId, double total, LocalDate date) {
        this.orderId = orderId;
        this.total = total;
        this.date = date;
        items = new ArrayList<>();

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

    public void addItem(Item item, int qty) {
        OrderItem newItem = new OrderItem(qty, item, item.getPrice());
        items.add(newItem);

    }

    public String toString() {
        return "Order ID: " + orderId + " Order total: " + total + " Items: " + 
    }

}
