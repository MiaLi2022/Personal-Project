package ui;

import model.Customer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.LinkedList;

import static com.sun.glass.ui.Cursor.setVisible;

// Represent a event after clicking Customers in menu
public class Customers {
    public JFrame frame;

    // Construct a frame for Customers event
    public Customers() {
        frame = new JFrame("Customers");

        JPanel jp = new JPanel();
        LayoutManager layout = new BoxLayout(jp, BoxLayout.Y_AXIS);
        jp.setLayout(layout);
        setButton(jp);

        frame.getContentPane().add(jp, BorderLayout.CENTER);
        frame.setSize(400, 170);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: a adding event after clicking add button
    private void addingToQueue() {
        int num = numberInput();
        String size = sizeOptions();

        Customer customer = new Customer(num, size);
        if (frame != null) {
            QueuingApp.queue.addCustomer(customer);
        }
        JOptionPane.showMessageDialog(frame, "Add Successfully!");
    }

    // MODIFIES: this
    // EFFECTS: a delete event after clicking delete button
    private void doDelete() {
        int num = numberInput();
        String size = sizeOptions();

        Customer customer = new Customer(num,size);
        QueuingApp.queue.deleteCustomer(customer);
        JOptionPane.showMessageDialog(frame, "Delete Successfully!");
    }

    // MODIFIES: this
    // EFFECTS: a view details event after clicking view button
    private void viewDetails() {
        int num = numberInput();
        String size = sizeOptions();

        String out = "The number of tables in front of you: "
                + QueuingApp.queue.getTableInFront(num,size) + "\n"
                + "The approximate waiting time: "
                + QueuingApp.queue.getWaitingTime(num,size);
        JOptionPane.showMessageDialog(QueuingApp.frame, out,
                "Waiting Information", JOptionPane.PLAIN_MESSAGE);
    }

    // MODIFIES: this
    // EFFECTS: a panel for user input waiting number
    public int numberInput() {
        String result = (String) JOptionPane.showInputDialog(
                frame,
                "Enter your wait number:",
                "Waiting Number",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "1");
        int num = Integer.parseInt(result);
        return num;
    }

    // MODIFIES: this
    // EFFECTS: a panel for user choose table size
    public String sizeOptions() {
        String[] choices = {"Small", "Medium", "Large","ExtraLarge"};
        String size = (String)JOptionPane.showInputDialog(
                frame,
                "Choose your table size：",
                "Table Size",
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                choices[0]);
        size = size.toLowerCase();

        return size;
    }

    // MODIFIES: this
    // EFFECTS: a mouse listener.
    //          When users click different buttons, display different events
    public void clickButton(JButton b1, JButton b2, JButton b3, JButton b4) {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
                addingToQueue();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
                doDelete();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
                viewDetails();
            }
        });

        b4Aciton(b4);
    }

    // EFFECTS: to scale icon for the suitable size for the button
    public ImageIcon scaleIcon(ImageIcon image,double index) {
        int width = (int) (image.getIconWidth() * index);
        int height = (int) (image.getIconHeight() * index);
        Image img = image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon newImg = new ImageIcon(img);
        return newImg;
    }

    // EFFECTS: play the sound of mouse clicks
    // REQUIRES: a valid path of music
    public void playSound() {
        try   {
            FileInputStream soundFile = new FileInputStream("./data/music/click.wav");
            AudioStream as = new AudioStream(soundFile);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            System.out.println("Fail to load sound.");
        }
    }

    // MODIFIES: this
    // EFFECTS: a mouse listener.
    //          When users click "Display Waiting List" button, display the waiting list table contained waiting numbber
    //          and preferred table size
    public void b4Aciton(JButton b4) {
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
                displayWaitingList();
            }
        });
    }

    // EFFECTS: set buttons to interact on the Customers page
    public void setButton(JPanel jp) {
        ImageIcon add = new ImageIcon("./data/images/add.jpg");
        ImageIcon delete = new ImageIcon("./data/images/delete.jpg");
        ImageIcon newAdd = scaleIcon(add,0.05);
        ImageIcon newDelete = scaleIcon(delete,0.04);

        JButton b1 = new JButton("Add to Queue");
        JButton b2 = new JButton("Delete from Queue");
        JButton b3 = new JButton("Check Your Waiting Information");
        JButton b4 = new JButton("Display Waiting List");
        b1.setIcon(newAdd);
        b2.setIcon(newDelete);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);

        clickButton(b1,b2,b3,b4);

        jp.add(b1);
        jp.add(b2);
        jp.add(b3);
        jp.add(b4);
    }

    // MODIFIES: this
    // EFFECTS: display waiting list in the format of table
    public void displayWaitingList() {
        LinkedList<Customer> customers = QueuingApp.queue.getCustomers();

        frame = new JFrame("Restaurants");
        frame.setSize(250,200);

        Object[][] tableDate = new Object[customers.size()][2];
        for (int i = 0; i < customers.size(); i++) {
            tableDate[i][0] = customers.get(i).getWaitingNumber();
            for (int j = 1;j < 2;j++) {
                tableDate[i][j] = customers.get(i).getTableSize();
            }
        }
        String[] name = {"Waiting Number","Preferred Table Size"};
        JTable table = new JTable(tableDate,name);
        table.setFont(new java.awt.Font("Dialog", Font.PLAIN,13));
        JScrollPane panel = new JScrollPane(table);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
