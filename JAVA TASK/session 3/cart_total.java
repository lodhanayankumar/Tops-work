/*4.Given this Java snippet: <br><br>int cartTotal = 450;
 * <br>String status = (cartTotal >= 500) ? 
 * "Eligible for Free Delivery" : "Add more items for Free Delivery";
 * <br><br>Use ChatGPT to generate two alternate ways to write this 
 * logic using if-else and nested conditions. Copy and implement
 * both in your code, then comment on which one you find clearer.
 */

public class cart_total {

	public static void main(String[] args) {

		int cartTotal =450;
        String status;
        //using if else
        if(cartTotal>=500)
        	  status ="Eligibal For Free Delivery";
          else
        	  status ="Add more iteam for Free Delivery";
          
          
        System.out.println("use if else : "+status);
        //use nested
        if(cartTotal>0) {
        	if(cartTotal>=500)
        		  status ="Eligibal For Free Delivery";
        	else
        		status ="Add more iteam for Free Delivery";
        }
        else {
        	 status = "Invalid Cart Total";
        }
        System.out.println("Using nested if: " + status);
	}

}
