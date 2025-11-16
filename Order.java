
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
        return total;
    }

}
