import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Inventory {
    private ArrayList<Product> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addProduct(String name, double weight, int quantity, Date dateAdded) {
        Product product = new Product(name, weight, quantity, dateAdded);
        items.add(product);
    }

    public void addToProductQuantity(String productName, int quantityToAdd) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                int newQuantity = product.getQuantity() + quantityToAdd;
                product.setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Error: Produce item not found in inventory. Please enter a known produce item or create new.");
    }

    public void removeProductQuantity(String productName, int quantityToRemove) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                int currentQuantity = product.getQuantity();
                if (currentQuantity >= quantityToRemove) {
                    product.setQuantity(currentQuantity - quantityToRemove);
                    return;
                } else {
                    System.out.println("Error: Quantity to remove exceeds the current quantity in the inventory.");
                    return;
                }
            }
        }
        System.out.println("Error: Produce item not found in inventory. Please enter a known produce item or create new.");
    }
    
    public double calculateTotalWeight(String productName) {
        double totalWeight = 0.0;
        for (Product product : items) {
            if (product.getName().equals(productName)) {
                totalWeight += product.getWeight() * product.getQuantity();
            }
        }
        return totalWeight;
    }
    
    public List<Product> searchForProdcuts(String productName) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product prodcut : items) {
            if (product.getName().equalsIsIgnoreCase(productName)) {
                matchingProducts.add(product);
            }
        }
            else {
                System.out.println("Error: Produce item not found in inventory. Please enter a known produce item or create new.");
            }
        return matchingProducts;
        }
    }

    public void showProductData (Product product) {
        if (product != null) {
            System.out.println("Product Data: ");
            System.out.println("Name: " + product.getName());
            System.out.println("Weight: " + product.getWeight());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Date Added: " + product.getDateAdded());
        }
        else{
            System.out.println("Error: Produce item not found in inventory. Please enter a known produce item or create new.");
        }
    }
}

