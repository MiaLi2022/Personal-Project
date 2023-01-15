package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


class QueueTest {
    Queue q1;

    @BeforeEach
    public void runBefore() {
        q1 = new Queue();
    }

    @Test
    public void testSearchTableQueue() {
        Customer c1 = new Customer(25,"small");
        Customer c2 = new Customer(10,"medium");
        Customer c3 = new Customer(2,"large");
        Customer c4 = new Customer(20,"extraLarge");
        Customer c5 = new Customer(90,"small");
        q1.addCustomer(c1);
        q1.addCustomer(c2);
        q1.addCustomer(c3);
        q1.addCustomer(c4);
        q1.addCustomer(c5);

        assertEquals(2,q1.searchTableQueue("small").size());
        assertEquals(1,q1.searchTableQueue("medium").size());
        assertEquals(1,q1.searchTableQueue("large").size());
        assertEquals(1,q1.searchTableQueue("extraLarge").size());
    }

    @Test
    public void testAddAndDeleteCustomer(){
        Customer c1 = new Customer(25,"small");
        Customer c5 = new Customer(90,"small");

        q1.addCustomer(c1);
        q1.addCustomer(c5);
        assertEquals(2,q1.searchTableQueue("small").size());

        q1.deleteCustomer(c5);
        assertEquals(1,q1.searchTableQueue("small").size());

        Customer c2 = new Customer(45,"large");
        q1.addCustomer(c2);
        assertEquals(1,q1.searchTableQueue("large").size());
        q1.deleteCustomer(c2);
        assertEquals(0,q1.searchTableQueue("large").size());

        Customer c3 = new Customer(45,"extraLarge");
        q1.addCustomer(c3);
        assertEquals(1,q1.searchTableQueue("extraLarge").size());
        q1.deleteCustomer(c3);
        assertEquals(0,q1.searchTableQueue("extraLarge").size());
    }

    @Test
    public void testGetWaitingTime() {
        Customer c1 = new Customer(25,"small");
        Customer c5 = new Customer(90,"small");
        q1.addCustomer(c1);
        q1.addCustomer(c5);
        assertEquals(20,q1.getWaitingTime(90,"small"));
        assertEquals(-1,q1.getWaitingTime(150,"small"));
    }

    @Test
    public void testGetTableInFront() {
        Customer c1 = new Customer(25,"small");
        Customer c5 = new Customer(90,"small");
        q1.addCustomer(c1);
        q1.addCustomer(c5);
        assertEquals(1,q1.getTableInFront(90,"small"));
        assertEquals(-1,q1.getTableInFront(120,"small"));
    }

    @Test
    public void testGetCustomers(){
        Customer c1 = new Customer(25,"small");
        Customer c2 = new Customer(10,"medium");
        Customer c3 = new Customer(2,"large");
        Customer c4 = new Customer(20,"extraLarge");
        q1.addCustomer(c1);
        q1.addCustomer(c2);
        q1.addCustomer(c3);
        q1.addCustomer(c4);

        LinkedList<Customer> customers = q1.getCustomers();
        assertEquals(25,customers.get(0).getWaitingNumber());
        assertEquals("small",customers.get(0).getTableSize());
        assertEquals(10,customers.get(1).getWaitingNumber());
        assertEquals("medium",customers.get(1).getTableSize());
        assertEquals(2,customers.get(2).getWaitingNumber());
        assertEquals("large",customers.get(2).getTableSize());
        assertEquals(20,customers.get(3).getWaitingNumber());
        assertEquals("extraLarge",customers.get(3).getTableSize());
    }
}