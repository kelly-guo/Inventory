
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class OrderHistory {

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
}
