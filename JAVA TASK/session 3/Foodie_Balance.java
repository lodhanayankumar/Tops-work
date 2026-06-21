/*1.Write a Java program called FoodieBalanceChecker that takes an
 *  integer input for wallet balance and prints 'Low Balance Warning.'
 *   if the balance is less than 100, otherwise prints 'Sufficient
 *   Balance.' using an if-else statement.
 */
import java.util.Scanner;
public class Foodie_Balance {

	public static void main(String[] args) {
	  Scanner obj= new Scanner(System.in);
	  System.out.println("------FoodieBalanceCheker-------");
	  System.out.println("Enter your wallet Balance : ");
	  float balance = obj.nextFloat();
	  if(balance<100)
		  System.out.print("Low Balance Warning...");
	  else
		  System.out.println("Sufficient Balance....");
	}

}
