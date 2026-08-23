/*1.Create a Java Bean class named Product with properties: id, name, price, and category. Add getter and 
 * setter methods for each property.
 */
package bean;

public class Product1 {

    private int id;
    private String name;
    private double price;
    private String category;

    // Default constructor
    public Product1() {
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}