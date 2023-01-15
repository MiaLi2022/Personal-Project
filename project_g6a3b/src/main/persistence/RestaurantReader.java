package persistence;

import model.Restaurant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that will read data from a file
// Based on: github.students.cs.ubc.ca/CPSC210/TellerApp/persistence/Reader.java
public class RestaurantReader {
    public static final String DELIMITER = ",";

    public RestaurantReader(){}

    // EFFECTS: returns a list of restaurants parsed from file
    public static List<Restaurant> readRestaurant(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns a list of strings which contains each row of file
    public static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of restaurants parsed from list of string which contains one restaurant's
    // information in each element
    private static List<Restaurant> parseContent(List<String> fileContent) {
        List<Restaurant> restaurants = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            restaurants.add(parseCustomer(lineComponents));
        }
        return restaurants;
    }

    // EFFECTS: split each line on DELIMITER and return a list of string which contains components of a restaurant
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 2 where element 0 represents restaurant's name and
    // element 1 represents restaurant's type
    // EFFECTS: returns a restaurant contains its name and type
    private static Restaurant parseCustomer(List<String> components) {
        String name  = components.get(0);
        String type = components.get(1);
        return new Restaurant(name,type);
    }
}
