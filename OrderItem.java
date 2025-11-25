
class OrderItem {

    private int qty;
    private Item item;
    private double cost;

    public OrderItem(int qty, Item item, double cost) {
        this.qty = qty;
        this.item = item;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public double getQuantity() {
        return qty;
    }

    public String getName() {
        return item.getName();
    }

    public Item getItem() {
        return item;
    }

}
