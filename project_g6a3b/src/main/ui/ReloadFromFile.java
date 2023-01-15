package ui;

import model.Customer;
import model.Queue;
import persistence.Reader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static ui.QueuingApp.frame;

// Represent a event after clicking Reload from file in menu
public class ReloadFromFile {
    private JLabel label = new JLabel("Reload From：");
    private JTextField jtf = new JTextField(20);
    private JButton btn = new JButton("Search");
    private JFrame jf = new JFrame("File Selector");
    private static String CUSTOMERS_IN_QUEUE_FILE;

    // EFFECTS: construct a panel for "reload from file" event
    public ReloadFromFile() {
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(jtf);
        panel.add(btn);
        jf.add(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        btn.addActionListener(new MyActionListener());
    }

    // MODIFIES: this
    // EFFECTS: load customers from a given file contained customers waiting number and preferred table size
    // REQUIRES: require a file contains customers information in correct format
    private void loadCustomers() {
        try {
            List<Customer> customers = Reader.readCustomers(new File(CUSTOMERS_IN_QUEUE_FILE));
            for (int i = 0; i < customers.size();i++) {
                QueuingApp.queue.addCustomer(customers.get(i));
            }
        } catch (IOException e) {
            initial();
        }
    }

    // MODIFIES: this
    // EFFECTS: add action listener when user choose a file to reload information
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser(
                    "/Users/jinghuili/Documents/CPSC210/project_g6a3b/data");
            int option = fileChooser.showSaveDialog(frame);
            if (option == fileChooser.APPROVE_OPTION) {
                jtf.setText(fileChooser.getSelectedFile().toString());
                CUSTOMERS_IN_QUEUE_FILE = jtf.getText();
                loadCustomers();
                JOptionPane.showMessageDialog(jtf,"Reload Successfully!");
                jf.setVisible(false);
            } else {
                jtf.setText("Cancel");
            }
        }
    }

    // EFFECTS: initials queue in restaurant if user fail to reload customers
    private void initial() {
        QueuingApp.queue = new Queue();
    }
}