package model;

// Represents a customer having a waiting number, table size
public class Customer {
    private  int waitingNumber;
    private  String tableSize;

    // EFFECTS: constructor a customer have given case number and table size
    public Customer(int waitingNumber,String tableSize) {
        this.waitingNumber = waitingNumber;
        this.tableSize = tableSize;
    }

    // EFFECTS: return waiting number
    public int getWaitingNumber() {
        return waitingNumber;
    }

    // EFFECTS: return table size
    public String getTableSize() {
        return tableSize;
    }
}
