package dotcom;
/**
 * Instances of the Produce class represents the whole of one specific product, including the name, weight and quantity of that product.
 */
public class Produce {
    /**
     * A String storing the name of the product
     */
    private String name;
    /**
     * An int storing the number of one product
     */
    private int quantity;
    /**
     * A double storing the weight of one unit of the product
     */
    private double weight;

    /**
     * Constructor for the class.
     * @param name		A String for the instance variable containing the name of the Produce.
     * @param weight	A double for the instance variable containing the weight of the Produce.
     * @param quantity	An int for the instance variable contaaining the quantity of the Produce.
     */
    public Produce(String name, double weight, int quantity) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    /**
     * Returns the object's stored String name.
     * @return	A String containing the value of the stored name variable of the object.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the object's stored integer quantity.
     * @return	An int containing the value of the stored quantity variable of the object.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the stored quantity variable of the object to the specified value.
     * @param quantity	An integer that the stored variable quantity will be set to.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Returns the object's stored double weight.
     * @return	A double containing the value of the stored weight variable of the object.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns a string representation of the stored variables of the object.
     * @return	A string of the value of the stored variables of the object, seperated by commas.
     */
    @Override
    public String toString() {
        return name + "," + quantity + "," + weight;
    }

    /**
     * Returns a string representation of the stored variables of the object in the specified format, each variable seperated by a new line char.
     * @return	A string of the value of the stored variables of the objects, with a header and seperated by new line chars.
     */
    public String toStringPretty() {
        return "Name: " + name + "\nQuantity: " + quantity + "\nWeight: " + weight +"\n";
    }
}
    