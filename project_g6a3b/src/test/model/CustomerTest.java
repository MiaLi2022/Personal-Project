package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    Customer c1;

    @BeforeEach
    public void runBefore() {
        c1 = new Customer(90,"small");
    }

    @Test
    public void testGetWaitingNum() {
        assertEquals(90,c1.getWaitingNumber());
    }

    @Test
    public void testGetTableSize() {
        assertEquals("small",c1.getTableSize());
    }
}
