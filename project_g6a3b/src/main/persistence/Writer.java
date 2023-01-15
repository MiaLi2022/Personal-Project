package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

// A writer that can write customer data to a file
public class Writer {
    private PrintWriter printWriter;

    // EFFECTS: conducts a writer that can write data to a file
    public Writer(File file) throws FileNotFoundException, UnsupportedEncodingException {
        printWriter = new PrintWriter(file,"UTF-8");
    }

    // MODIFIES: this
    // EFFECTS: writes savable data to file
    public void write(Savable savable) {
        savable.save(printWriter);
    }

    // MODIFIES: this
    // EFFECTS: close print writer
    public void close() {
        printWriter.close();
    }
}
