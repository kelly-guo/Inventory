
import java.util.ArrayList;
import java.util.List;

public class Supplier {

    private String name;
    private List<Item> products;
    private String contactInfo;

    public Supplier(String name, String contact) {
        this.name = name;
        products = new ArrayList<>();
        this.contactInfo = contact;

    }

    public Supplier(String name, List<Item> products, String contact) {
        this.name = name;
        this.products = products;
        this.contactInfo = contact;

    }

    public void addSupplierProduct(Item product) {
        products.add(product);
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getName() {
        return name;
    }

    public List<Item> getSuppItems() {
        return products;
    }

}
