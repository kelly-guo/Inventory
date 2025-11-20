
import java.time.LocalDate;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Inventorymanager manager = new Inventorymanager();
        OrderHistory history = new OrderHistory();
        Scanner scanner = new Scanner(System.in);
        int id = 0;

        System.out.println("Welcome to the Java Inventory Management System!");
        System.out.println("1 - Place an order");
        System.out.println("2 - Alter inventory");
        System.out.println("3 - Quit program");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        if (choice == 1) {
            Order order = new Order(id++, 0, LocalDate.now());
            System.out.println("Would you like to search by product name or ID?");
            System.out.println("1 - Name");
            System.out.println("2 - ID");
            int searchChoice = Integer.parseInt(scanner.nextLine().trim());
            if (searchChoice == 1) {
                System.out.println("Enter product name: ");
                String prodName = scanner.nextLine().trim();
                Item item = manager.searchByName(prodName);
                System.out.println("Would you like to add " + item.getName() + " to your order?");
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                int orderChoice = Integer.parseInt(scanner.nextLine().trim());
                if (orderChoice == 1) {

                }

            } else if (searchChoice == 2) {
                System.out.println("Enter ID: ");
                int searchId = Integer.parseInt(scanner.nextLine().trim());
                Item item = manager.getItem(searchId);
            }

        }
    }

}
