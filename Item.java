
class Item {

    private String name;
    private int id;
    private double price;
    private int quantity;
    private String category;

    public Item(String name, int id, double price, int quantity, String category) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setQty(int num) {
        quantity = num;
    }

    public void setPrice(double num) {
        price = num;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("ID: " + id);

    }

}
