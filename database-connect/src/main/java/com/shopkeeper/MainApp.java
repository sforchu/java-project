package com.shopkeeper;

import com.shopkeeper.database.DataBaseConnection;
import com.shopkeeper.database.ItemRepository;
import com.shopkeeper.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.createConnection();

        // re-stock - add and update items

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select option from the list of Operations");
        System.out.println("==========================================");
        System.out.println("Press 1: to add item");
        System.out.println("Press 2: to update item inventory");
        //System.out.println("Press 3: to remove item");
        System.out.println("Press 3: to place order");
        System.out.println("Press 4: to view cart");
        System.out.println("Press 5: to exit application");

        while (true) {
            int operation = scanner.nextInt();
            ItemRepository itemRepository = new ItemRepository(connection);
            switch (operation) {
                case 1:
                    // adding item
                    Item item = getUserItem(scanner);

                    int addedCount = itemRepository.addItem(item);
                    if (addedCount == 1) {
                        System.out.println("Item added successfully");
                    }

                    System.out.println("============Enter next Operation========");
                    break;
                case 2:
                    System.out.println("Enter Item number: ");
                    int itemNumber = scanner.nextInt();

                    System.out.println("Enter item qty: ");
                    int qty = scanner.nextInt();

                    itemRepository.updateItemInventory(itemNumber, qty);

                    System.out.println("============Enter next Operation========");
                    break;
                case 3:
                    System.out.println("Enter customer Name: ");
                    String custName = scanner.next();
                    System.out.println("Enter Items ID (comma separated): ");
                    String itenCommSeparated = scanner.next();
                    String[] itemStrIds = itenCommSeparated.split(",");

                    boolean placeOrderCount = itemRepository.placeOrder(custName, itemStrIds);
                    if (placeOrderCount) {
                        System.out.println("Order placed successfully: ");
                    }

                    System.out.println("============Enter next Operation========");
                    break;
                case 4:
                    List<Item> items = itemRepository.viewInventory();
                    for (Item itm: items) {
                        System.out.println("ID: " + itm.getId());
                        System.out.println("Name: " + itm.getName());
                        System.out.println("Qty: " + itm.getQuantity());
                        System.out.println("Cost Price: " + itm.getCostPrice());
                        System.out.println("Selling Price: " + itm.getSellingPrice());

                        System.out.println("**************************************");
                    }
                    System.out.println("============Enter next Operation========");
                    break;
                case 5:
                    System.out.println("Exiting application");
                    return;
                default:
                    System.out.println("Wrong operation number");
            }

        }

    }

    public static Item getUserItem(Scanner scanner){
        System.out.println("Enter item ID: ");
        int id = scanner.nextInt();

        System.out.println("Enter item Name: ");
        String name = scanner.next();

        System.out.println("Enter the quantity: ");
        int qty = scanner.nextInt();

        System.out.println("Enter item cost price: ");
        double costPrice = scanner.nextDouble();

        System.out.println("Enter item selling price: ");
        double sellingPrice = scanner.nextDouble();

        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setQuantity(qty);
        item.setCostPrice(costPrice);
        item.setSellingPrice(sellingPrice);
        return item;
    }
}
