import java.util.ArrayList;

class Inventory {
    private ArrayList<Produce> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addProduce(String name, double weight, int quantity) {
        Produce produce = new Produce(name, weight, quantity);
        items.add(produce);
    }

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
    public double calculateTotalWeight(String produceName) {
        double totalWeight = 0.0;
        for (Produce produce : items) {
            if (produce.getName().equals(produceName)) {
                totalWeight += produce.getWeight() * produce.getQuantity();
            }
        }
        return totalWeight;
    }
}

