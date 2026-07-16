/* task 1Menu Item Class with Encapsulation
Build a well-encapsulated Java class that models a single item on a food delivery platform's
menu, demonstrating access control, constructor overloading, and formatted output.
*Define a class MenuItem with private fields: itemId (int), name (String), price (double), and
isAvailable (boolean).
*Provide a default constructor that sets isAvailable to true and price to 0.0, and a
parameterized constructor that accepts and sets all four fields.
*Implement getters for all four fields; provide setters only for price and isAvailable — itemId and
name must be read-only after construction.
*Add a displayDetails() method that prints a formatted one-line summary; if isAvailable is false
the line must include the text '[UNAVAILABLE]' after the item name.
*/
package assesment;

class MenuItem {

    // Private fields
    private int itemId;
    private String name;
    private double price;
    private boolean isAvailable;

    // Default Constructor
    public MenuItem() {
        itemId = 0;
        name = "Not Set";
        price = 0.0;
        isAvailable = true;
    }

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

    // Setters (Only for price and availability)
    public void setPrice(double price) {
        this.price = price;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Display Method
    public void displayDetails() {

        if (isAvailable) {
            System.out.println("Item ID : " + itemId +
                    " | Name : " + name +
                    " | Price : ₹" + price);
        } else {
            System.out.println("Item ID : " + itemId +
                    " | Name : " + name + " [UNAVAILABLE]" +
                    " | Price : ₹" + price);
        }
    }
}

public class B_task1 {

    public static void main(String[] args) {

        // Default Constructor
        MenuItem m1 = new MenuItem();

        // Parameterized Constructor
        MenuItem m2 = new MenuItem(101, "Pizza", 250.0, true);
        MenuItem m3 = new MenuItem(102, "Burger", 150.0, false);

        System.out.println("Menu Items:");
        m1.displayDetails();
        m2.displayDetails();
        m3.displayDetails();

        // Updating price and availability
        m2.setPrice(220.0);
        m3.setIsAvailable(true);

        System.out.println("\nAfter Update:");
        m2.displayDetails();
        m3.displayDetails();
    }
}