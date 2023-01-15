package persistence;

import model.Customer;
import model.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriterTest {
    private static final String TEST_FILE = "./data/testFile/WriterTestFile.txt";

    Writer writer;
    Queue q1;

    @BeforeEach
    public void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new Writer(new File(TEST_FILE));
        q1 = new Queue();
    }

    @Test
    public void testWrite() throws IOException {
        Customer c1 = new Customer(25,"small");
        Customer c2 = new Customer(10,"medium");
        q1.addCustomer(c1);
        q1.addCustomer(c2);

        writer.write(q1);
        writer.close();
        assertEquals("25,small",Reader.readFile(new File(TEST_FILE)).get(0));
        assertEquals("10,medium",Reader.readFile(new File(TEST_FILE)).get(1));
    }
}
