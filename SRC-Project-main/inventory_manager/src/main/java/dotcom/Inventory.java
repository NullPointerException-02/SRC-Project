import java.util.ArrayList;

class Inventory {
    private ArrayList<Produce> items;

    /**
     * Class constructor, initializes the ArrayList
     */
    public Inventory() {
        items = new ArrayList<>();
    }

    /**
     * Add a new product into the current ArrayList with the given name, weight and quantity as object fields.
     * @param name		A string containing the name of the product	
     * @param weight	A double containing the weight of one product
     * @param quantity	An integer containing the number of one product stored
     */
    public void addProduce(String name, double weight, int quantity) {
        Produce produce = new product;
        items.add(produce);
    }

    /**
     * Add an amount quantityToAdd to the product in the ArrayList with the specificed produceName.
     * If there's no product with that name in the ArrayList, output an error message and exit the method.
     * @param produceName	A string indicating the name of the product to add the quantity to.
     * @param quantityToAdd	An integer containing the number to add to the existing quantity of the product.
     */
    public void addToExistingEntry(String produceName, int quantityToAdd) {
        for (Produce produce : items) {
            if (produce.getName().equals(produceName)) {
                int newQuantity = produce.getQuantity() + quantityToAdd;
                produce.setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Error: Produce item not found in inventory.");
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
    /**
     * 
     */
    public showProducts() {
        /*TODO write showProducts method, a method that returns each product name, as well as a quantity 
        ex: apple(5)
            toothpaste(44) 
            hand warmers(5)
            Jacket(5)*/
    }
    /**
     * 
     * @param produceName
     */
    public searchForProduct(String produceName){
        /*
        basic search implementation, searches the items (the arraylist that stores ALL of the items we are tracking)
        and returns a specified object's information */
    }
}

