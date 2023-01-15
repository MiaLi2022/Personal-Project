package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Create a menu on the top of the queuing application frame
public class Menu extends JMenuBar implements ActionListener {

    // EFFECTS: construct a menu
    public Menu() {
        add(createMenu());
        setVisible(true);
    }

    // EFFECTS: create a menu with items: Restaurants, Customers, Save To File, Reload From File Quit Application
    public JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem item1 = new JMenuItem("Restaurants");
        mouseOverRestaurants(item1);
        item1.addActionListener(this);
        menu.add(item1);

        JMenuItem item2 = new JMenuItem("Customers");
        mouseOverCustomers(item2);
        item2.addActionListener(this);
        menu.add(item2);
        menu.addSeparator();

        JMenuItem item3 = new JMenuItem("Save To File");
        item3.addActionListener(this);
        menu.add(item3);
        JMenuItem item4 = new JMenuItem("Reload From File");
        item4.addActionListener(this);
        menu.add(item4);
        menu.addSeparator();

        JMenuItem item5 = new JMenuItem("Quit Application");
        item5.addActionListener(this);
        menu.add(item5);
        menuBar.add(menu);

        return menuBar;
    }

    // EFFECTS: when mouse over item "Restaurants", show information
    public void mouseOverRestaurants(JMenuItem item) {
        item.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                item.setToolTipText("Click to see restaurants' name and type.");
            }
        });
    }

    // EFFECTS: when mouse over item "Customers", show information
    public void mouseOverCustomers(JMenuItem item) {
        item.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                item.setToolTipText("Click to add, delete and check queue.");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: display different events when user click item on the menu
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        if (source.getText().equals("Restaurants")) {
            Restaurants restaurants = new Restaurants();
        } else if (source.getText().equals("Customers")) {
            Customers customers = new Customers();
        } else if (source.getText().equals("Save To File")) {
            SaveToFile save = new SaveToFile();
        } else if (source.getText().equals("Reload From File")) {
            ReloadFromFile reload = new ReloadFromFile();
        } else {
            QueuingApp.frame.setVisible(false);
        }
    }
}