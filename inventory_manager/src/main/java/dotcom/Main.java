package dotcom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    // Create an instance of Inventory
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {

        inventory.loadInventory("inventory.txt");
        
        // Add a shutdown hook to save the inventory when the program is closed
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            inventory.saveInventory("inventory.txt");
        }));

        // GUI components
        JFrame frame = new JFrame("Inventory Management System");
        JButton addButton = new JButton("Add Product");
        JButton removeButton = new JButton("Remove Product");
        JButton addButtonQuantity = new JButton("Add Quantity");
        JButton removeButtonQuantity = new JButton("Remove Quantity");
        JButton showProductButton = new JButton("Show Product");
        JTextField searchBar = new JTextField(20);
        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);  // Make textArea non-editable
        JScrollPane scrollPane = new JScrollPane(textArea);  // Add scroll pane for text area

        // Setting up the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(addButtonQuantity);
        buttonPanel.add(removeButtonQuantity);
        buttonPanel.add(showProductButton);

        // Setting up the panel for search
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchBar);

        // Adding components to the frame
        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(searchPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Set frame properties
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Action listeners
        searchBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String productName = searchBar.getText();
              List<Produce> results = inventory.searchForProducts(productName);
              
              // Clear the text area before displaying results
              textArea.setText("");
              
              if (results.isEmpty()) {
                textArea.append("Error: Product item not found in inventory.\n");
              } else {
                textArea.append("Search results for '" + productName + "':\n");
                for (Produce product : results) {
                  textArea.append(product.toStringPretty() + "\n"); // Display product details using Produce.toString()
                }
              }
            }
          });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventory.showAddProductDialogue(); // Call the method to show add product dialogue
                
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productName = JOptionPane.showInputDialog(frame, "Enter product name to remove quantity:");
                if (productName != null && !productName.isEmpty()) {
                    String quantityString = JOptionPane.showInputDialog(frame, "Enter quantity to remove:");
                    try {
                        int quantity = Integer.parseInt(quantityString);
                        if (quantity <= 0) {
                            throw new IllegalArgumentException("Quantity must be a positive integer.");
                        }
        
                        ArrayList<Produce> items_copy = inventory.getItems(); // Create a copy to avoid ConcurrentModificationException
        
                        boolean found = false;
                        for (int i = 0; i < items_copy.size(); i++) {
                            Produce produce = items_copy.get(i);
                            if (produce.getName().equals(productName)) {
                                int currentQuantity = produce.getQuantity();
                                if (quantity > currentQuantity) {
                                    textArea.append("Error: Insufficient quantity of " + productName + ". Only " + currentQuantity + " available.\n");
                                } else {
                                    int newQuantity = currentQuantity - quantity;
                                    produce.setQuantity(newQuantity);
                                    textArea.append("Removed " + quantity + " units of " + productName + " from inventory.\n");
                                    found = true;
                                    break;
                                }
                            }
                        }
        
                        if (!found) {
                            textArea.append("Error: " + productName + " not found in inventory.\n");
                        }
                    } catch (NumberFormatException ex) {
                        textArea.append("Invalid quantity format. Please enter a positive integer.\n");
                    } catch (IllegalArgumentException ex) {
                        textArea.append(ex.getMessage() + "\n"); // Display specific error message
                    }
                }
            }
        });

        addButtonQuantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productName = JOptionPane.showInputDialog(frame, "Enter product name to add quantity:");
                if (productName != null && !productName.isEmpty()) {
                    String quantityString = JOptionPane.showInputDialog(frame, "Enter quantity to add:");
                    try {
                        ArrayList<Produce> items_copy = inventory.getItems();
                        int quantity = Integer.parseInt(quantityString);
                        boolean found = false;
                        for (Produce produce : items_copy) {
                            if (produce.getName().equals(productName)) {
                                int newQuantity = produce.getQuantity() + quantity;
                                produce.setQuantity(newQuantity);
                                textArea.append("Added " + quantity + " units of " + productName + " to inventory.\n");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            textArea.append("Error: " + productName + " not found in inventory.\n");
                        }
                    } catch (NumberFormatException ex) {
                        textArea.append("Invalid quantity format.\n");
                    }
                }
            }
        });
        

        showProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show product details logic
                textArea.append(inventory.ShowAllProduceData()); // Call the method to show produce details
            }
        });
        
    }
}
