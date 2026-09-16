/*1.Create a POJO class named Product with fields id, name, and price, along with getters and setters, 
 * to represent a Flipkart-style product item.
 */

package pattern02;

public class Product201 {
     
	 private int id;
    private String name;
    private double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString(){
		return "Product{" + "id=" + id + ", name='" + name + '\'' + ", price=₹" + price + '}';
	}
}
