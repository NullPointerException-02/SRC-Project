package dotcom;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        
     // GUI components
      JFrame frame;
      JButton addButton;
      JButton showButton;
    
        // Initialize GUI components
        frame = new JFrame("Inventory Management System");
        addButton = new JButton("Add Product");
        showButton = new JButton("Show Products");

        // Add action listeners to buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle add button click event
                // This is where you might open a dialog for adding a new product
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle show button click event
                // This is where you might display the list of products in a table or list
            }
        });

        // Add GUI components to the frame
        frame.add(addButton);
        frame.add(showButton);

        // Set frame properties
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    
       






        
    }
}
