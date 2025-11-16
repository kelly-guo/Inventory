
import java.time.LocalDate;

class Transaction {

    private String category; //Add, Remove, Update
    private int id;
    private LocalDate time;
    private int qty;
    private Item item;

    public Transaction(String category, int id, LocalDate time, int qty, Item item) {
        this.category = category;
        this.id = id;
        this.time = time;
        this.qty = qty;
    }

    public Transaction(String category, int id, LocalDate time, Item item) {
        this.category = category;
        this.id = id;
        this.time = time;
    }

    public void printTransaction() {
        if (category.equals("Add")) {
            System.out.println("You added " + item.getName() + " to the system on " + time);
        } else if (category.equals("Remove")) {

        }
        System.out.println("");
    }

}
