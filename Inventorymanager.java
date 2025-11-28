
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventorymanager {

    Map<Integer, Item> map; //id, item
    List<Transaction> history;

    public Inventorymanager() {
        map = new HashMap<>();
        history = new ArrayList<>();

    }

    public void addNewProduct(Item item) {
        if (map.containsValue(item)) {
            System.out.println("This item is already in the system!");
        } else {
            map.put(item.getId(), item);
            Transaction addition = new Transaction("Add", item.getId(), LocalDate.now(), item);
            history.add(addition);
        }
    }

    public void removeItem(int id) {
        if (map.containsKey(id)) {
            map.remove(id);
            Transaction remove = new Transaction("Remove", id, LocalDate.now(), map.get(id));
        } else {
            System.out.println("This ID is not in the system!");
        }

    }

    public void updateStock(int qty, int id) {
        if (map.containsKey(id)) {
            Item item = map.get(id);
            item.setQty(qty);
            Transaction update = new Transaction("Update", item.getId(), LocalDate.now(), qty, item);
            history.add(update);
        } else {
            System.out.println("This ID is not in the system!");
        }
    }

    public Item searchByName(String name) {
        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
            Item item = entry.getValue();
            if (item.getName().equals(name)) {
                return item;
            }

        }
        System.out.println("The name is not in the system!");
        return null;
    }

    public Item getItem(int id) {
        if (map.containsKey(id)) {
            return map.get(id);
        } else {
            System.out.println("The ID is not in the system!");
            return null;
        }
    }

    public List<Item> searchByCategory(String category) {
        List<Item> result = new ArrayList<>();
        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
            Item item = entry.getValue();
            if (item.getCategory().equals(category)) {
                result.add(item);
            }

        }
        return result;
    }

    public List<Item> getLowStock(int min) {
        List<Item> lowStock = new ArrayList<>();
        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
            Item item = entry.getValue();
            if (item.getQuantity() <= min) {
                lowStock.add(item);
            }

        }
        return lowStock;

    }

    public double getTotalValue() {
        double total = 0;
        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
            Item item = entry.getValue();
            total += item.getPrice() * item.getQuantity();
        }
        return total;

    }

    public List<Transaction> getHistory() {
        return history;
    }

}
