import java.util.Scanner;

public class bookmy_show {

	public static void main(String[] args) {
      int a;// a is age variable
      boolean b;// b is payment method variable
	  Scanner obj= new Scanner(System.in);
	  System.out.print("Enter your Age : ");
	  a = obj.nextInt();
	  System.out.print("do you have PaymentMethod? (True/False) :");
	  b = obj.nextBoolean();
	  if(a>17 && b)
	  {
		  System.out.print("Booking alowed ");
	  }
	  else
	  {
		  System.out.print("You are not Eligibal for Ticket BOOking ");
	  }
	}

}
//Create a Java snippet that checks if a user 
//can book a movie ticket on BookMyShow: declare 
//variables for userAge (int) and hasPaymentMethod (boolean).
//Use logical and relational operators to print 'Booking allowed'
//only if the user is 18 or older and has a payment method linked.