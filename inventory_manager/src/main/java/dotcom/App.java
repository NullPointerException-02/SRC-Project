package dotcom;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    // Establish database connection, make database, and 
   
     // GUI components
     private JFrame frame;
     private JButton addButton;
     private JButton showButton;
     public App() {
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




    public List<Product> showProducts() {
        /*TODO: write method showProducts
        Step 1: Establish a database connection

        Step 2: Prepare SQL statement to select all products

        Step 3: Execute the SQL query and retrieve the result set

        Step 4: Iterate over the result set and extract product details

        Step 5: Create Product object using retrieved data

        Step 6: Add Product object to the list

        Return the list of products

        Return empty list in case of error */
    }

    public void insertProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO products (name, price, date) VALUES (?, ?, ?)")) {
		statement.setString(1, product.getName());
		statement.setDouble(2, product.getDate());
		SimpleDateFormat dateFormat = new SimpleDateFormat(MM/dd/yyyy);
		String date = dateFormat.format(product.getDate());
		statement.setString(3, date);
		statement.executeUpdate();
          } catch (SQLException e) {
		e.printStackTrace();
	}
    }

    public void deleteProduct(int productId) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id = ?")) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods for additional functionalities

    public static void main(String[] args) {
        App app = new App();

        // Example usage:
        List<Product> products = app.showProducts();
        for (Product product : products) {
            System.out.println(product); // Print product details
        }
        
        // Example product insertion (replace with actual data)
        
        // Example product deletion (replace with actual ID)
        
    }
}
