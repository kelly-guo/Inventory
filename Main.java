
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
        System.out.println("3 - View History");
        System.out.println("4 - Quit program");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        if (choice == 1) {
            boolean inOrder = true;
            Order order = new Order(id++, 0, LocalDate.now());
            while (inOrder) {
                System.out.println("1 - Add products to order");
                System.out.println("2 - See your purchase total");
                System.out.println("3 - Review order");
                System.out.println("4 - Place order");
                int orderOption = Integer.parseInt(scanner.nextLine().trim());
                if (orderOption == 1) {
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
                            System.out.println("How many would you like to add?");
                            int quantity = Integer.parseInt(scanner.nextLine().trim());
                            order.addItem(item, quantity);
                        } else {

                        }

                    } else if (searchChoice == 2) {
                        System.out.println("Enter ID: ");
                        int searchId = Integer.parseInt(scanner.nextLine().trim());
                        Item item = manager.getItem(searchId);
                        System.out.println("Would you like to add " + item.getName() + " to your order?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        int orderChoice = Integer.parseInt(scanner.nextLine().trim());
                        if (orderChoice == 1) {
                            System.out.println("How many would you like to add?");
                            int quantity = Integer.parseInt(scanner.nextLine().trim());
                            order.addItem(item, quantity);
                        } else {

                        }
                    }
                } else if (orderOption == 2) {
                    double total = order.getPurchaseTotal();
                    System.out.println("Your purchase total is: " + total);

                } else if (orderOption == 3) {
                    System.out.println(order.toString());
                } else if (orderOption == 4) {
                    history.addOrder(order);
                    break;
                }
            }

        } else if (choice == 2) {
            boolean inSystem = true;
            while (inSystem) {
                System.out.println("1 - Add new product");
                System.out.println("2 - Update stock");
                System.out.println("3 - Remove a product");
                System.out.println("4 - Get low stock");
                System.out.println("5 - Get total value of inventory");
                int inventoryChoice = Integer.parseInt(scanner.nextLine().trim());
                if (inventoryChoice == 1) {
                    System.out.println("Enter in product name: ");
                    String prodName = scanner.nextLine().trim();
                    System.out.println("Enter in ID: ");
                    int prodId = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Enter in price: ");
                    double prodPrice = Double.parseDouble(scanner.nextLine().trim());
                    System.out.println("Enter in quantity: ");
                    int prodQty = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Enter in category: ");
                    String category = scanner.nextLine().trim();
                    Item newItem = new Item(prodName, id, prodPrice, prodQty, category);
                    manager.addNewProduct(newItem);

                } else if (inventoryChoice == 2) {
                    System.out.println("Enter in ID: ");
                    int prodId = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Enter in quantity: ");
                    int prodQty = Integer.parseInt(scanner.nextLine().trim());
                    manager.updateStock(prodQty, prodId);

                }
            }

        }
    }

}
