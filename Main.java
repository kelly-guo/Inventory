
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("3 - View history");
        System.out.println("4 - Search for a product");
        System.out.println("5 - View order status");
        System.out.println("6 - Manage Shippers");
        System.out.println("7 - Quit program");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        if (choice == 1) {
            boolean inOrder = true;
            Order order = new Order(id++, 0, LocalDate.now(), "Pending");
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
                    System.out.println("You placed your order. ID: " + order.getId());
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
                System.out.println("6 - Go Back");
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

                } else if (inventoryChoice == 3) {
                    System.out.println("Enter in ID: ");
                    int prodId = Integer.parseInt(scanner.nextLine().trim());
                    manager.removeItem(prodId);

                } else if (inventoryChoice == 4) {
                    System.out.println("What should the threshold for low stock be?");
                    int min = Integer.parseInt(scanner.nextLine().trim());;
                    List<Item> lowStock = manager.getLowStock(min);
                    for (Item item : lowStock) {
                        item.print();
                    }
                } else if (inventoryChoice == 5) {
                    double total = manager.getTotalValue();
                    System.out.println("All products are worth: " + total);
                } else if (inventoryChoice == 6) {
                    break;
                }
            }

        } else if (choice == 3) {
            System.out.println("1 - View order history");
            System.out.println("2 - View managing history");
            int historyChoice = Integer.parseInt(scanner.nextLine().trim());
            if (historyChoice == 1) {
                System.out.println("1 - Get orders from date-date");
                System.out.println("2 - Get total sales from date-date");
                System.out.println("3 - Get top categories");
                System.out.println("4 - Get average order value from date-date");
                System.out.println("5 - Get total amount of orders fom date-date");
                int orderChoice = Integer.parseInt(scanner.nextLine().trim());
                if (orderChoice == 1) {
                    List<Order> list = new ArrayList<>();
                    System.out.println("Enter in date 1 (MM/DD/YYYY): ");
                    String date1 = scanner.nextLine().trim();
                    String[] date = date1.split("/");
                    int year1 = Integer.parseInt(date[2]);
                    int day1 = Integer.parseInt(date[1]);
                    int month1 = Integer.parseInt(date[0]);
                    LocalDate start = LocalDate.of(year1, month1, day1);
                    System.out.println("Enter in date 2 (MM/DD/YYYY): ");
                    String date2 = scanner.nextLine().trim();
                    String[] date2s = date2.split("/");
                    int year2 = Integer.parseInt(date2s[2]);
                    int day2 = Integer.parseInt(date2s[1]);
                    int month2 = Integer.parseInt(date2s[0]);
                    LocalDate end = LocalDate.of(year1, month1, day1);

                    list = history.getOrdersFrom(start, end);
                    for (Order o : list) {
                        System.out.println(o.toString());
                    }
                } else if (orderChoice == 2) {
                    System.out.println("Enter in date 1 (MM/DD/YYYY): ");
                    String date1 = scanner.nextLine().trim();
                    String[] date = date1.split("/");
                    int year1 = Integer.parseInt(date[2]);
                    int day1 = Integer.parseInt(date[1]);
                    int month1 = Integer.parseInt(date[0]);
                    LocalDate start = LocalDate.of(year1, month1, day1);
                    System.out.println("Enter in date 2 (MM/DD/YYYY): ");
                    String date2 = scanner.nextLine().trim();
                    String[] date2s = date2.split("/");
                    int year2 = Integer.parseInt(date2s[2]);
                    int day2 = Integer.parseInt(date2s[1]);
                    int month2 = Integer.parseInt(date2s[0]);
                    LocalDate end = LocalDate.of(year1, month1, day1);
                    double total = history.getTotalSalesFrom(start, end);
                    System.out.println("The total for all sales from " + start + " to " + end + " was " + total);

                } else if (orderChoice == 3) {
                    List<String> res = history.getTopCategory();
                    if (res.size() > 1) {
                        System.out.println("The top categories are: ");
                        for (String cat : res) {
                            System.out.println(cat);
                            System.out.println(" ");
                        }
                    } else {
                        System.out.println("The top category is: " + res.get(0));

                    }
                } else if (orderChoice == 4) {
                    System.out.println("Enter in date 1 (MM/DD/YYYY): ");
                    String date1 = scanner.nextLine().trim();
                    String[] date = date1.split("/");
                    int year1 = Integer.parseInt(date[2]);
                    int day1 = Integer.parseInt(date[1]);
                    int month1 = Integer.parseInt(date[0]);
                    LocalDate start = LocalDate.of(year1, month1, day1);
                    System.out.println("Enter in date 2 (MM/DD/YYYY): ");
                    String date2 = scanner.nextLine().trim();
                    String[] date2s = date2.split("/");
                    int year2 = Integer.parseInt(date2s[2]);
                    int day2 = Integer.parseInt(date2s[1]);
                    int month2 = Integer.parseInt(date2s[0]);
                    LocalDate end = LocalDate.of(year1, month1, day1);
                    double value = history.averageOrderValueFrom(start, end);
                    System.out.println("The average order value from " + start + " to " + end + " is " + value);

                } else if (orderChoice == 5) {
                    System.out.println("Enter in date 1 (MM/DD/YYYY): ");
                    String date1 = scanner.nextLine().trim();
                    String[] date = date1.split("/");
                    int year1 = Integer.parseInt(date[2]);
                    int day1 = Integer.parseInt(date[1]);
                    int month1 = Integer.parseInt(date[0]);
                    LocalDate start = LocalDate.of(year1, month1, day1);
                    System.out.println("Enter in date 2 (MM/DD/YYYY): ");
                    String date2 = scanner.nextLine().trim();
                    String[] date2s = date2.split("/");
                    int year2 = Integer.parseInt(date2s[2]);
                    int day2 = Integer.parseInt(date2s[1]);
                    int month2 = Integer.parseInt(date2s[0]);
                    LocalDate end = LocalDate.of(year1, month1, day1);
                    int total = history.getTotalOrdersFrom(start, end);
                    System.out.println("The total amount of orders from " + start + " to " + end + " is " + total);

                }
            } else if (historyChoice == 2) {
                List<Transaction> list = manager.getHistory();
                for (Transaction t : list) {
                    t.printTransaction();
                }

            }
        } else if (choice == 4) { //add searching for orders with product
            System.out.println("Would you like to search by?");
            System.out.println("1 - Name");
            System.out.println("2 - ID");
            System.out.println("3 - Category");
            System.out.println("4 - Product (Finding orders)");
            int searchSystem = Integer.parseInt(scanner.nextLine().trim());
            if (searchSystem == 1) {
                System.out.println("Enter name: ");
                String prodName = scanner.nextLine().trim();
                Item item = manager.searchByName(prodName);
                item.print();
                System.out.println("Would you like to see orders including this item?");
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                int searchOrder = Integer.parseInt(scanner.nextLine().trim());
                if (searchOrder == 1) {
                    List<Order> list = history.getOrderList();
                    for (Order order : list) {
                        List<OrderItem> items = order.getOrderItems();
                        for (OrderItem i : items) {
                            if (i.getName().equals(prodName)) {
                                System.out.println(order.toString());
                            }

                        }

                    }

                }
            } else if (searchSystem == 2) {
                System.out.println("Enter ID: ");
                int prodId = Integer.parseInt(scanner.nextLine().trim());
                Item item = manager.getItem(id);
                item.print();
                System.out.println("Would you like to see orders including this item?");
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                int searchOrder = Integer.parseInt(scanner.nextLine().trim());
                if (searchOrder == 1) {
                    List<Order> list = history.getOrderList();
                    for (Order order : list) {
                        List<OrderItem> items = order.getOrderItems();
                        for (OrderItem i : items) {
                            if (i.getItem().getId() == (prodId)) {
                                System.out.println(order.toString());
                            }

                        }

                    }

                }
            } else if (searchSystem == 3) {
                System.out.println("Enter category: ");
                String prodCat = scanner.nextLine().trim();
                List<Item> list = new ArrayList<>();
                list = manager.searchByCategory(prodCat);
                for (Item item : list) {
                    item.print();
                }

            } else if (searchSystem == 4) { //maybe redundant
                System.out.println("Name of product: ");
                String prodName = scanner.nextLine().trim();
                List<Order> list = history.getOrderList();
                for (Order order : list) {
                    List<OrderItem> items = order.getOrderItems();
                    for (OrderItem i : items) {
                        if (i.getName().equals((prodName))) {
                            System.out.println(order.toString());
                        }

                    }

                }

            }

        } else if (choice == 5) {
            System.out.println("Enter in your order ID: ");
            int orderId = Integer.parseInt(scanner.nextLine().trim());
            List<Order> list = history.getOrderList();
            Order order = null;
            for (Order o : list) {
                if (o.getId() == orderId) {
                    order = o;

                }
            }
            if (order == null) {
                System.out.println("This ID is not in the system!");
            } else {
                System.out.println(order.toString());
                System.out.println("Your order is: ");
                order.updateStatus();
                String status = order.getStatus();
                if (status.equals("Pending")) {
                    System.out.println("Your order is pending");
                } else if (status.equals("Shipped")) {
                    System.out.println("Your order is on the way");
                } else {
                    System.out.println("Your order has arrived!");
                }

            }

        } else if (choice == 6) {
            System.out.println("1 - Add a new shipper");
            System.out.println("2 - Search for a shipper");
            int shipChoice = Integer.parseInt(scanner.nextLine().trim());
        }

    }
}
