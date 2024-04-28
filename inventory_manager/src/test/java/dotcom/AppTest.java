package dotcom;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest 
{
    /**
     * Tests the addProduce function in the inventory class 
     */
    @Test
    void testInventory_addProduce() 
    {
        String name = "apple";
        double weight = 4.5;
        int quantity = 9;
        Inventory testinventory = new Inventory();
        testinventory.addProduce(name, weight, quantity);
        ArrayList<Produce> items = testinventory.getItems();
        assertEquals(items.get(0).getName(), name);
        assertEquals(items.get(0).getWeight(), weight);
        assertEquals(items.get(0).getQuantity(), quantity);
    }

    /**
     * Tests the addToExistingEntry function in the inventory class 
     */
    @Test
    void testInventory_addToExistingEntry() 
    {
        String name = "apple";
        double weight = 4.5;
        int quantity = 9;
        int quantitytoradd = 4;
        Inventory testinventory = new Inventory();
        testinventory.addProduce(name, weight, quantity);
        testinventory.addToExistingEntry(name, quantitytoradd);
        ArrayList<Produce> items = testinventory.getItems();
        assertEquals(items.get(0).getName(), name);
        assertEquals(items.get(0).getWeight(), weight);
        assertEquals(items.get(0).getQuantity(), (quantity + quantitytoradd));
    }

    /**
     * Tests the addToExistingEntry function in the inventory class 
     */
    @Test
    void testInventory_removeQuantity()
    {
        String name = "apple";
        double weight = 4.5;
        int quantity = 9;
        int quantitytoremove = 4;
        Inventory testinventory = new Inventory();
        testinventory.addProduce(name, weight, quantity);
        testinventory.removeQuantity(name, quantitytoremove);
        ArrayList<Produce> items = testinventory.getItems();
        assertEquals(items.get(0).getName(), name);
        assertEquals(items.get(0).getWeight(), weight);
        assertEquals(items.get(0).getQuantity(), (quantity - quantitytoremove));
    }

    /**
     * Tests the searchForProducts function in the inventory class 
     */
    @Test
    void testInventory_searchForProducts()
    {
        String name = "apple";
        double weight = 4.5;
        int quantity = 9;
        Inventory testinventory = new Inventory();
        testinventory.addProduce(name, weight, quantity);
        List<Produce> items = testinventory.searchForProducts(name);
        assertEquals(items.get(0).getName(), name);
        assertEquals(items.get(0).getWeight(), weight);
        assertEquals(items.get(0).getQuantity(), (quantity));
    }
}

