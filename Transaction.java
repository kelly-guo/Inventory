
import java.time.LocalDate;

class Transaction {

    private String category; //Add, Remove, Update
    private int id;
    private LocalDate time;
    private int qty;

    public Transaction(String category, int id, LocalDate time, int qty) {
        this.category = category;
        this.id = id;
        this.time = time;
        this.qty = qty;
    }

    public Transaction(String category, int id, LocalDate time) {
        this.category = category;
        this.id = id;
        this.time = time;
    }

}
