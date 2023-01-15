package ui;

import model.Restaurant;
import persistence.RestaurantReader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

// Represent a event after clicking Restaurants in menu
public class Restaurants {
    private static final String RESTAURANTS_IN_QUEUE_FILE = "./data/restaurants.txt";
    public static List<Restaurant> restaurants;
    public static JFrame frame;

    //EFFECTS: construct a restaurant frame with a table which showed information about restaurants' name and type
    public Restaurants() {
        loadRestaurants();
        frame = new JFrame("Restaurants");
        frame.setSize(700,400);

        Object[][] tableDate = new Object[restaurants.size()][2];
        for (int i = 0; i < restaurants.size(); i++) {
            tableDate[i][0] = restaurants.get(i).getName();
            for (int j = 1;j < 2;j++) {
                tableDate[i][j] = restaurants.get(i).getType();
            }
        }
        String[] name = {"Name","Type"};
        JTable table = new JTable(tableDate,name);
        table.setFont(new java.awt.Font("Dialog", Font.PLAIN,13));
        JScrollPane panel = new JScrollPane(table);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: load restaurants information from a given file
    private void loadRestaurants() {
        try {
            this.restaurants = RestaurantReader.readRestaurant(new File(RESTAURANTS_IN_QUEUE_FILE));
        } catch (IOException e) {
            System.out.println("fail to reload!");
        }
    }
}