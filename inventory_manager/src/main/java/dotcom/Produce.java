package dotcom;
public class Produce {
    private String name;
    private int quantity; // New field for quantity
    private double weight;

    public Produce(String name, double weight, int quantity) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public int getQuantity() { // Getter for quantity
        return quantity;
    }

    public void setQuantity(int quantity) { // Setter for quantity
        this.quantity = quantity;
    }
    
    public double getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return name + "," + quantity + "," + weight;
    }

    
    public String toStringPretty() {
        return "Name: " + name + "\nQuantity: " + quantity + "\nWeight: " + weight +"\n";
    }
    
    
}
    