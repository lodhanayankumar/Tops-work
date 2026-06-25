/*2.Build a class FoodOrder with a method calculateTotal() that returns the 
 * order amount, then extend it with a ZomatoGoldOrder subclass that 
 * overrides calculateTotal() to apply a 10% discount for Gold users.
 * 
 * This program demonstrates method overriding and the use of the
 * super keyword. The parent class returns the original order amount,
 * while the child class applies a 10% discount for Zomato Gold users.
 */

class Foodorder {
	
	// Stores the original order amount
	double orderamount;
	
	// Constructor to initialize order amount
	Foodorder(double orderamount) {
		this.orderamount = orderamount;
	}
	
	// Returns the original order total
	double calculateTotal() {
		return orderamount;
	}
}

// Child class that represents a Zomato Gold order
class ZomatoGoldOrder extends Foodorder {
	
	// Constructor that calls the parent constructor
	ZomatoGoldOrder(double orderamount) {
		super(orderamount);
	}
	
	// Overrides calculateTotal() to apply 10% discount
	@Override
	double calculateTotal() {
		
		// Get original total from parent class
		double total = super.calculateTotal();
		
		// Calculate 10% discount
		double discount = total * 0.10;
		
		// Return final amount after discount
		return total - discount;
	}
}

public class Foodorder_zomatogold {

	public static void main(String[] args) {
		
		// Create a normal food order
		Foodorder bill = new Foodorder(1000);
		System.out.println("Total Bill : " + bill.calculateTotal());

		// Create a Zomato Gold order with discount
		ZomatoGoldOrder dis = new ZomatoGoldOrder(1000);
		System.out.println("Zomato Gold Order : " + dis.calculateTotal());
	}
}