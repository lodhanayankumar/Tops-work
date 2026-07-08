/*3.Simulate a Flipkart shopping cart by creating an ArrayList of Product objects (with name and price). 
 * Write a method to calculate and print the total cart value.
 */
import java.util.ArrayList;
class product{
	String name;
	double price;
	product(String name, double price){
		this.name=name;
		this.price=price;
	}
	public void display() {
		System.out.println("Product name : "+name);
		System.out.println("Price : "+price);
		System.out.println();
	}
}
public class flip_cart_Arry {
	public static void calculateTotal(ArrayList<product> cart) {
		double total=0;
		for(product p:cart) {
			total=total+p.price;
		}
		System.out.println("Total cart Value : "+total);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    ArrayList<product> cart =new ArrayList<>();
    cart.add(new product("Readmi note 12",12000));
    cart.add(new product("Samsung M 12",21000));
    cart.add(new product("Apple 13",150000));
    cart.add(new product("phone charger",520));
    
    System.out.println("product in cart: \n");
    for(product p: cart) {
    	p.display();
    }
    calculateTotal(cart);
	}

}
