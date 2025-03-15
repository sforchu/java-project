package com.shopkeeper.database;

import com.shopkeeper.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private Connection connection;

    // Generate a constructor
    public ItemRepository(Connection connection) {
        this.connection = connection;
    }

    //create a method AddItem
    public int addItem(Item item) {
        try {
            // use connection object to write a query to add things to the database
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into items (id, name, qty, cost_price, selling_price) values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, item.getQuantity());
            preparedStatement.setDouble(4, item.getCostPrice());
            preparedStatement.setDouble(5, item.getSellingPrice());
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error occurred in adding Item: " + ex.getMessage());
            return 0;
        }
    }


    //create a method updateItemInventory
    public int updateItemInventory(int itemNumber, int qty) {
        try {
            // use connection object to write a query to add things to the database
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE items SET qty=? WHERE id=?");
            preparedStatement.setInt(1, qty);
            preparedStatement.setInt(2, itemNumber);
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error occurred in updating Item: " + ex.getMessage());
            return 0;
        }
    }

    //create a method viewInventory
    public List<Item> viewInventory() {

        List<Item> items = new ArrayList<>();
        try{


            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setQuantity(resultSet.getInt("qty"));
                item.setCostPrice(resultSet.getDouble("cost_price"));
                item.setSellingPrice(resultSet.getDouble("selling_price"));

                items.add(item);
            }


        } catch (Exception ex) {
            System.out.println("Error occurred viewing list: " + ex.getMessage());

        }
        return items;

    }


    // create a new method placeOrder

    public boolean placeOrder(String customerName, String items[]){
        return true;


    }


}
