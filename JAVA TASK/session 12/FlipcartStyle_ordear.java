/*3.Build a Flipkart-style order ID generator using StringBuilder. Start with 'ORD' and append a random 
 * 6-digit number, then print the final order ID (e.g., ORD483921).
 */
import java.util.Random;
public class FlipcartStyle_ordear {

	public static void main(String[] args) {

	        Random random = new Random();

	        // Generate a random 6-digit number (100000 to 999999)
	        int number = 100000 + random.nextInt(900000);

	        // Create Order ID using StringBuilder
	        StringBuilder orderId = new StringBuilder("ORD");

	        orderId.append(number);

	        System.out.println("Order ID: " + orderId);
	    }
	}