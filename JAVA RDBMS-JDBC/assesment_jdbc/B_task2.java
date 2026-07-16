/*Task 2 :  Cart Manager with Collections and Custom Exceptions
Build a cart manager for the food delivery app that stores items in an ArrayList and enforces
business rules by throwing custom exceptions for invalid operations.
*Create a custom checked exception ItemUnavailableException that extends Exception and
stores the unavailable item's name in a meaningful error message.
*Implement a CartManager class that holds an ArrayList<MenuItem> and provides
addItem(MenuItem item) and removeItem(int itemId) methods.
*addItem() must throw ItemUnavailableException if the item's isAvailable flag is false;
removeItem() must throw NoSuchElementException if no item with the given ID exists in the list.
*Add a displayCart() method that iterates the ArrayList and prints each item's name and price,
then prints the calculated grand total on a final line; if the cart is empty, print 'Cart is empty'
instead */
package assesment;

import java.util.ArrayList;
import java.util.NoSuchElementException;

// Custom Checked Exception
class ItemUnavailableException extends Exception {

    public ItemUnavailableException(String itemName) {
        super("Item '" + itemName + "' is unavailable.");
    }
}

// MenuItem Class
class MenuItem {

    private int itemId;
    private String name;
    private double price;
    private boolean isAvailable;

    // Parameterized Constructor
    public MenuItem(int itemId, String name, double price, boolean isAvailable) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    // Getters
    public int getItemId() {
        return itemId;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
}
// CartManager Class
class CartManager {
    private ArrayList<MenuItem> cart = new ArrayList<>();
    // Add Item
    public void addItem(MenuItem item) throws ItemUnavailableException {
        if (!item.getIsAvailable()) {
            throw new ItemUnavailableException(item.getName());
        }
        cart.add(item);
        System.out.println(item.getName() + " added to cart.");
    }
    // Remove Item
    public void removeItem(int itemId) {

        for (int i = 0; i < cart.size(); i++) {

            if (cart.get(i).getItemId() == itemId) {
                System.out.println(cart.get(i).getName() + " removed from cart.");
                cart.remove(i);
                return;
            }
        }
        throw new NoSuchElementException("Item with ID " + itemId + " not found.");
    }
    // Display Cart
    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        double total = 0;
        System.out.println("\n----- Cart -----");
        for (MenuItem item : cart) {
            System.out.println("Name : " + item.getName()+ " | Price : " + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("-------------------------");
        System.out.println("Grand Total : " + total);
    }
}

// Main Class
public class B_task2 {

    public static void main(String[] args) {

        CartManager cart = new CartManager();
        MenuItem m1 = new MenuItem(101, "Pizza", 250.0, true);
        MenuItem m2 = new MenuItem(102, "Burger", 150.0, false);
        MenuItem m3 = new MenuItem(103, "Pasta", 200.0, true);
        // Add Items
        try {
            cart.addItem(m1);
        } catch (ItemUnavailableException e) {
            System.out.println(e.getMessage());
        }
        try {
            cart.addItem(m2);
        } catch (ItemUnavailableException e) {
            System.out.println(e.getMessage());
        }
        try {
            cart.addItem(m3);
        } catch (ItemUnavailableException e) {
            System.out.println(e.getMessage());
        }
        cart.displayCart();
        // Remove Items
        try {
            cart.removeItem(101);
            cart.removeItem(105);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        cart.displayCart();
    }
}