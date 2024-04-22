import java.util.ArrayList;

class Inventory {
    private ArrayList<Product> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addProduct(String name, double weight, int quantity) {
        Product product = new Product(name, weight, quantity);
        items.add(product);
    }

    public void addToExistingEntry(String productName, int quantityToAdd) {
        for (Product product : items) {
            if (product.getName().equals(productName)) {
                int newQuantity = product.getQuantity() + quantityToAdd;
                product.setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Error: Produce item not found in inventory.");
    }

    public void removeQuantity(String productName, int quantityToRemove) {
        for (Product product : items) {
            if (product.getName().equals(productName)) {
                int currentQuantity = product.getQuantity();
                if (currentQuantity >= quantityToRemove) {
                    product.setQuantity(currentQuantity - quantityToRemove);
                    return;
                } else {
                    System.out.println("Error: Quantity to remove exceeds current quantity in inventory.");
                    return;
                }
            }
        }
        System.out.println("Error: Produce item not found in inventory.");
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
}

