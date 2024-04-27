package dotcom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Inventory {
    private ArrayList<Produce> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public ArrayList<Produce> getItems() {
        return items;
    }
       
      /**
     * Add a new product into the current ArrayList with the given name, weight and quantity as object fields. automatically generates unique ID
     * @param name		A string containing the name of the product	
     * @param weight	A double containing the weight of one product
     * @param quantity	An integer containing the number of one product stored
     */
    public void addProduce(String name, double weight, int quantity) {
        // Assuming you have a method to generate unique IDs, let's call it generateUniqueId()
        Produce produce = new Produce(name, weight, quantity);
        produce.setQuantity(quantity); // Set the quantity
        items.add(produce);
    }
     /**
     * Add an amount quantityToAdd to the product in the ArrayList with the specificed produceName.
     * If there's no product with that name in the ArrayList, output an error message and exit the method.
     * @param produceName	A string indicating the name of the product to add the quantity to.
     * @param quantityToAdd	An integer containing the number to add to the existing quantity of the product.
     */
    public void addToExistingEntry(String produceName, int quantityToAdd ) {
        for (Produce produce : items) {
            if (produce.getName().equals(produceName)) {
                int newQuantity = produce.getQuantity() + quantityToAdd;
                produce.setQuantity(newQuantity);
                return;
            }
            else;
            System.out.println("Error: Produce item not found in inventory.");
        }
        
    }
/**
     * Remove an amount quantityToRemove to the product in the ArrayList with the indicated produceName.
     * If the quantity to remove is greater than the existing quantity of the product, output an error message and exit the method.
     * If there's no product with that name in the ArrayList, output an error method and exit the method.
     * @param produceName	 A string indicating the name of the product to remove the quantity from.
     * @param quantityToRemove An integer indicating the number to remove from the existing quantity of the product.
     */
    public void removeQuantity(String produceName, int quantityToRemove) {
        for (Produce produce : items) {
            if (produce.getName().equals(produceName)) {
                int currentQuantity = produce.getQuantity();
                if (currentQuantity >= quantityToRemove) {
                    produce.setQuantity(currentQuantity - quantityToRemove);
                    return;
                } else {
                    System.out.println("Error: Quantity to remove exceeds current quantity in inventory.");
                    return;
                }
            }
        }
        System.out.println("Error: Produce item not found in inventory.");
    }
    public void showAddProductDialogue() {
        JFrame frame = new JFrame("Add Produce");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(300, 200);

        // Create input fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(10);
        JLabel weightLabel = new JLabel("Weight:");
        JTextField weightField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(10);

        // Create button
        JButton addButton = new JButton("Add Produce");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduce(nameField.getText(), Double.parseDouble(weightField.getText()), Integer.parseInt(quantityField.getText()));
                frame.dispose(); // Close the dialogue after adding the product
            }
        });

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);
        constraints.gridx = 1;
        panel.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(weightLabel, constraints);
        constraints.gridx = 1;
        panel.add(weightField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(quantityLabel, constraints);
        constraints.gridx = 1;
        panel.add(quantityField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(addButton, constraints);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public List<Produce> searchForProducts(String productName) {
        List<Produce> matchingProducts = new ArrayList<>();
        for (Produce product : items) {
            if (product.getName().equalsIgnoreCase(productName)) {
                matchingProducts.add(product);
            }
        }
        if (matchingProducts.isEmpty()) {
            System.out.println("Error: Product item not found in inventory. Please enter a known product item or create new.");
        }
        return matchingProducts;
    }
    
    public void showProduceData (Produce produce) {
        if (produce != null) {
            System.out.println("Produce Data: ");
            System.out.println("Name: " + produce.getName());
            System.out.println("Weight: " + produce.getWeight() + "lbs");
            System.out.println("Quantity: " + produce.getQuantity());
        }
        else {
            System.out.println("Error: Produce item not found in inventory. Please enter a known produce item or create new.");
        }
    }

    public String ShowAllProduceData() {
        StringBuilder output = new StringBuilder();
        if (!items.isEmpty()) {
            output.append("Produce Data for all items:\n");
            for (Produce produce : items) {
                output.append("Name: ").append(produce.getName()).append("\n");
                output.append("Weight: ").append(produce.getWeight()).append("\n");
                output.append("Quantity: ").append(produce.getQuantity()).append("\n\n");
            }
        } else {
            output.append("No produce items found in inventory.\n");
        }
        return output.toString();
    }
    public void saveInventory(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Produce product : items) {
                writer.write(product.toString()); // Write each product to the file
                writer.write(System.lineSeparator()); // Add newline after each product
            }
            System.out.println("Inventory data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving inventory data: " + e.getMessage());
        }
    }
    public void loadInventory(String filename) {
        items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse each line to create Produce objects and add them to the inventory
                // Assuming each line represents a product in the format: Name,Quantity,Weight
                String[] parts = line.split(","); // Split line by comma
                if (parts.length == 3) { // Check if line is in correct format
                    String name = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());
                    double weight = Double.parseDouble(parts[2].trim());
                    items.add(new Produce(name, weight, quantity));
                }
            }
            System.out.println("Inventory data loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading inventory data: " + e.getMessage());
        }
    }
    









}    

   

