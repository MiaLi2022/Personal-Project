package ui;

import persistence.Writer;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

// Represent a event after clicking Save To File in menu
public class SaveToFile {
    private static final String CUSTOMERS_IN_QUEUE_FILE = "./data/customers.txt";

    // EFFECTS: construct a pop window for "save to file" event
    public SaveToFile() {
        int result = JOptionPane.showConfirmDialog(QueuingApp.frame,
                "Do you want to save queue information？",
                "Save Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            try {
                Writer writer = new Writer(new File(CUSTOMERS_IN_QUEUE_FILE));
                writer.write(QueuingApp.queue);
                writer.close();
                JOptionPane.showMessageDialog(QueuingApp.frame,
                        "Save successfully in: " + CUSTOMERS_IN_QUEUE_FILE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(QueuingApp.frame,
                        "Unable to save in: " + CUSTOMERS_IN_QUEUE_FILE);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
