/*4.Create a Java class called MovieTicket for a BookMyShow-style app,
 *  with attributes: movieTitle (String) and seatNumber (String). 
 *  Add a constructor to initialize both attributes and a method 
 *  printTicket() to display the ticket details.
 */
// Define the MovieTicket class
class Ticket{
	// Attributes
	 String movieTitle;
	 String seatNumber;
	 // Constructor to initialize both attributes
	 public Ticket(String Title, String Number) {
		 movieTitle = Title;
		 seatNumber = Number;
	 }
	// Method to display ticket details
	 void printTicket() {
		 System.out.println("movie Title : "+movieTitle);
		 System.out.println("Seat Number : "+seatNumber);
	 }
	 
}
public class BookMy_Show {

	public static void main(String[] args) {
		 // Create a MovieTicket object using the constructor  
		Ticket t1= new Ticket("bhulbulaiya","prime s1");
          t1.printTicket();
          Ticket t2= new Ticket("babu saheb","Gold-d1");
          t2.printTicket();
	}

}
