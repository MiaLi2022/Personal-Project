package persistence;

import model.Customer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that will read data from a file
// Based on: github.students.cs.ubc.ca/CPSC210/TellerApp/persistence/Reader.java
public class Reader {
    public static final String DELIMITER = ",";

    public Reader(){}

    // EFFECTS: returns a list of customers parsed from file
    public static List<Customer> readCustomers(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns a list of strings which contains each row of file
    public static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of customers parsed from list of string which contains one customer's
    // information in each element
    private static List<Customer> parseContent(List<String> fileContent) {
        List<Customer> customers = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            customers.add(parseCustomer(lineComponents));
        }
        return customers;
    }

    // EFFECTS: split each line on DELIMITER and return a list of string which contains components of a customer
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 2 where element 0 represents the waiting number of the customer and
    // element 1 represents the table size which was chose by customer
    // EFFECTS: returns a customer contained each components
    private static Customer parseCustomer(List<String> components) {
        int waitingNum = Integer.parseInt(components.get(0));
        String tableSize = components.get(1);
        return new Customer(waitingNum,tableSize);
    }
}
