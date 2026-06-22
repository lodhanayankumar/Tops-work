// Standard: Class names should always start with a capital letter (CartItem)
class CartItem {
    // Standard: Use camelCase for attribute names (itemName)
    String itemName;
    int quantity;
	
    void increaseQuantity() {
        quantity++; // Adds 1 to the quantity
        System.out.println("Updated quantity of " + itemName + ": " + quantity);
    }
}
	
// Standard: The public class name must perfectly match your file name (e.g., Main)
public class Cartiteam {
	
    public static void main(String[] args) {
        // Create the object using the corrected class name
        CartItem c = new CartItem();
        c.itemName = "Laptop";
        c.quantity = 1;
        
        // Call the method twice to observe the value changing over time
        c.increaseQuantity();
        c.increaseQuantity();
    }
}
