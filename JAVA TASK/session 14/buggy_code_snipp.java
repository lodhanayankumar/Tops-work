/*4.Given the following buggy code snippet for a ticket booking system, debug and fix it so that it 
 * correctly throws and catches InsufficientFundsException and prints the right error message when the 
 * user's balance is less than the ticket price:

   try {
   int userBalance = 100;
   int ticketPrice = 150;
   if (userBalance < ticketPrice) {
   throw new InsufficientFundsException();
   }
   System.out.println("Booking successful!");
   } catch (Exception e) {
   System.out.println("Error: " + e.getMessage());
   }
<em><strong>Hint:</strong> Make sure the InsufficientFundsException class provides a meaningful message and is properly caught.</em>
*/
class InsufficientFundsException extends Exception{
	InsufficientFundsException(String messege)  {
		super(messege);
	}
}
public class buggy_code_snipp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   try {
			   int userBalance = 100;
			   int ticketPrice = 150;
			   if (userBalance < ticketPrice) {
			   throw new InsufficientFundsException("Insufficient Balance for Ticket Booking");
			   }
			   System.out.println("Booking successful!");
			   } catch (Exception e) {
			   System.out.println("Error: " + e.getMessage());
			   }
	}

}
