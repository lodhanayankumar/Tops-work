package mini_project_C_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MenuDAO {

    // Load Menu from Database
    public ArrayList<MenuItem> loadMenu() {

        ArrayList<MenuItem> menuList = new ArrayList<>();

        String sql = "SELECT * FROM menu_items";

        try (
                Connection con = database_connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                MenuItem item = new MenuItem(
                        rs.getInt("item_id"),
                        rs.getString("restaurant_name"),
                        rs.getString("item_name"),
                        rs.getDouble("price"),
                        rs.getBoolean("available"));

                menuList.add(item);
            }

        } catch (Exception e) {
            System.out.println("Database Error : " + e.getMessage());
        }

        return menuList;
    }

    // Display Menu
    public void displayMenu(ArrayList<MenuItem> menuList) {

        if (menuList.isEmpty()) {
            System.out.println("No Menu Items Found.");
            return;
        }

        System.out.println("\n================ FOOD MENU ================");

        System.out.printf("%-8s %-18s %-20s %-10s %-15s%n",
                "ID",
                "Restaurant",
                "Item",
                "Price",
                "Status");

        System.out.println("--------------------------------------------------------------------------");

        for (MenuItem item : menuList) {

            String status;

            if (item.isAvailable()) {
                status = "Available";
            } else {
                status = "Not Available";
            }

            System.out.printf("%-8d %-18s %-20s %-10.2f %-15s%n",
                    item.getItemId(),
                    item.getRestaurantName(),
                    item.getItemName(),
                    item.getPrice(),
                    status);
        }

        System.out.println("--------------------------------------------------------------------------");
    }

    // Find Menu Item by ID
    public MenuItem getMenuItemById(int itemId) {

        String sql = "SELECT * FROM menu_items WHERE item_id = ?";

        try (
                Connection con = database_connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, itemId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new MenuItem(
                            rs.getInt("item_id"),
                            rs.getString("restaurant_name"),
                            rs.getString("item_name"),
                            rs.getDouble("price"),
                            rs.getBoolean("available"));
                }
            }

        } catch (Exception e) {
            System.out.println("Database Error : " + e.getMessage());
        }

        return null;
    }

}