package persistence;

import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReaderTest {
    private static final String TEST_FILE = "./data/testFile/ReaderTestFile.txt";
    List<Customer> readers;
    Reader r1;

    @BeforeEach
    public void runBefore() throws IOException {
        r1 = new Reader();
        readers = Reader.readCustomers(new File(TEST_FILE));
    }

    @Test
    public void readFileTest() {
        assertEquals(1,readers.get(0).getWaitingNumber());
        assertEquals("small",readers.get(0).getTableSize());
        assertEquals(2,readers.get(1).getWaitingNumber());
        assertEquals("medium",readers.get(1).getTableSize());
        assertEquals(7,readers.get(2).getWaitingNumber());
        assertEquals("large",readers.get(2).getTableSize());
        assertEquals(5,readers.get(3).getWaitingNumber());
        assertEquals("extraLarge",readers.get(3).getTableSize());
    }
}