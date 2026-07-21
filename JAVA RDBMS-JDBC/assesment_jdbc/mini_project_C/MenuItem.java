package mini_project_C_jdbc;

public class MenuItem {

    private int itemId;
    private String restaurantName;
    private String itemName;
    private double price;
    private boolean available;

    public MenuItem(int itemId, String restaurantName, String itemName, double price, boolean available) {
        this.itemId = itemId;
        this.restaurantName = restaurantName;
        this.itemName = itemName;
        this.price = price;
        this.available = available;
    }

    public int getItemId() {
        return itemId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}