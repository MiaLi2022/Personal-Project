package ui;

import model.Queue;

import javax.swing.*;
import java.awt.*;

// Create GUI fro the restaurant queuing application
public class QueuingApp extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 500;
    public static JFrame frame;
    public static Queue queue;

    // EFFECTS: construct a frame with welcome image, welcome label and a menu
    public QueuingApp() {
        queue = new Queue();

        frame = new JFrame("Restaurant Queuing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        panel.setLayout(layout);

        ImageIcon image = new ImageIcon("./data/images/HelloFood.gif");
        JLabel welcomeImage = new JLabel();
        welcomeImage.setIcon(image);
        welcomeImage.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeImage,BorderLayout.CENTER);

        JLabel welcome = new JLabel("Welcome to Queuing Restaurant Application!");
        welcome.setFont(new java.awt.Font("Dialog", Font.PLAIN, 30));
        welcome.setForeground(Color.DARK_GRAY);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcome,BorderLayout.NORTH);

        frame.add(panel);
        frame.setSize(WIDTH,HEIGHT);
        createAndShowMenu(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: create a menu
    private static void createAndShowMenu(JFrame frame) {
        frame.setJMenuBar(new Menu());
    }

    // EFFECTS: run queuing application
    public static void main(String[] args) {
        new QueuingApp();
    }
}
