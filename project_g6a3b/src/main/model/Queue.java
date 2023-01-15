package model;

import persistence.Reader;
import persistence.Savable;

import java.io.PrintWriter;
import java.util.LinkedList;

// Represent a queue of customers waiting for a specific size of table in the restaurant
public class Queue implements Savable {
    public static final int MAX_SIZE = 10;

    public LinkedList<Customer> smallTableQueue;
    public LinkedList<Customer> mediumTableQueue;
    public LinkedList<Customer> largeTableQueue;
    public LinkedList<Customer> extraLargeQueue;


    // EFFECTS: construct empty restaurant queues for different table size
    public Queue() {
        smallTableQueue = new LinkedList<>();
        mediumTableQueue = new LinkedList<>();
        largeTableQueue = new LinkedList<>();
        extraLargeQueue = new LinkedList<>();
    }

    // EFFECTS: search table queue by a given table size, return that table queue
    public LinkedList searchTableQueue(String size) {
        if (size == "small") {
            return smallTableQueue;
        } else if (size == "medium") {
            return mediumTableQueue;
        } else if (size == "large") {
            return largeTableQueue;
        } else {
            return extraLargeQueue;
        }
    }

    // MODIFIES: this
    // EFFECTS: add customers into the particular table queue
    public void addCustomer(Customer customer) {
        searchTableQueue(customer.getTableSize()).add(customer);
    }

    // MODIFIES: this
    // EFFECTS: remove customers from the particular table queue
    public void deleteCustomer(Customer customer) {
        int waitingNum = customer.getWaitingNumber();
        String size = customer.getTableSize();

        LinkedList<Customer> targetQueue = searchTableQueue(size);

        for (int i = 0; i < searchTableQueue(size).size(); i++) {
            if (targetQueue.get(i).getWaitingNumber() == waitingNum) {
                searchTableQueue(size).remove(i);
            }
        }
    }

    // EFFECTS: return the approximate waiting time
    //          if the waiting number not exists, return -1
    // Assume each person need approximately 20 minutes to wait for a table.
    public int getWaitingTime(int waitingNum,String size) {
        LinkedList<Customer> targetQueue = searchTableQueue(size);
        for (int i = 0; i < searchTableQueue(size).size(); i++) {
            if (targetQueue.get(i).getWaitingNumber() == waitingNum) {
                return 20 * i;
            }
        }
        return -1;
    }

    // EFFECT: returns the number of tables waiting in front
    //         if the waiting number not exists, return -1
    public int getTableInFront(int waitingNum,String size) {
        LinkedList<Customer> targetQueue = searchTableQueue(size);
        for (int i = 0; i < searchTableQueue(size).size(); i++) {
            if (targetQueue.get(i).getWaitingNumber() == waitingNum) {
                return i;
            }
        }
        return -1;
    }

    // EFFECTS: returns all customers in queue as a list
    public LinkedList getCustomers() {
        LinkedList<Customer> customerList = new LinkedList<>();
        for (int i = 0; i < smallTableQueue.size(); i++) {
            customerList.add(smallTableQueue.get(i));
        }
        for (int i = 0; i < mediumTableQueue.size(); i++) {
            customerList.add(mediumTableQueue.get(i));
        }
        for (int i = 0; i < largeTableQueue.size(); i++) {
            customerList.add(largeTableQueue.get(i));
        }
        for (int i = 0; i < extraLargeQueue.size(); i++) {
            customerList.add(extraLargeQueue.get(i));
        }
        return customerList;
    }


    @Override
    public void save(PrintWriter printWriter) {
        LinkedList<Customer> customers = getCustomers();
        for (int i = 0; i < customers.size(); i++) {
            printWriter.print(customers.get(i).getWaitingNumber());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(customers.get(i).getTableSize() + System.lineSeparator());
        }
    }
}
