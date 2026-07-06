/*2.Simulate a Flipkart-style wallet: write a Java program that asks the user for their wallet balance and 
 * purchase amount, then uses try-catch to handle the case where the purchase exceeds the balance by 
 * displaying an error message.
 */
import java.util.Scanner;
class insuficientbalance extends Exception{
	insuficientbalance(String Messeges){
		super(Messeges);
	}
}
public class simulate_flipcart_wallet {

	public static void main(String[] args) {
	
		Scanner sc =new Scanner(System.in);
		try {
			System.out.println("Enter your Balance : ");
			double Balance =sc.nextDouble();
			System.out.println("Enter your Purches Value : ");
			double amount=sc.nextDouble();
			if(amount>Balance) {
				throw new insuficientbalance("Error: insufficient balance.");
			}
			
			Balance = Balance-amount;
			System.out.println("Purches Succesful......");
			System.out.println("remaining Balance : "+Balance);
		}catch(insuficientbalance e){
			System.out.println(e.getMessage());
		}
	}

}
