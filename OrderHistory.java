
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHistory {

    List<Order> orders;

    public OrderHistory() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersFrom(LocalDate t1, LocalDate t2) {
        List<Order> res = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            LocalDate date = (LocalDate) orders.get(i).getDate();
            if (date.isAfter(t1) && date.isBefore(t2)) {
                res.add(orders.get(i));
            }
        }
        return res;
    }

    public double getTotalSalesFrom(LocalDate t1, LocalDate t2) {
        double sum = 0;
        for (int i = 0; i < orders.size(); i++) {
            LocalDate date = (LocalDate) orders.get(i).getDate();
            if (date.isAfter(t1) && date.isBefore(t2)) {
                sum += orders.get(i).getPurchaseTotal();
            }
        }
        return sum;

    }

    public List<String> getTopCategory() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            List<OrderItem> curr = (List<OrderItem>) orders.get(i).getOrderItems();
            for (OrderItem item : curr) {
                String cat = item.getItem().getCategory();
                if (map.containsKey(cat)) {
                    map.put(cat, map.get(cat) + 1);
                } else {
                    map.put(cat, 1);
                }
            }

        }
        List<String> res = new ArrayList<>();
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > max) {
                max = count;
                res.clear();
                res.add(entry.getKey());

            }
        }
        return res;
    }
}
