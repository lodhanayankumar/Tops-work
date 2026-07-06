/*3.Build a method sendMoney(int amount) for a Paytm-like app that throws a custom 
 * InsufficientFundsException if the user tries to send more than their current balance. 
 * Catch and handle this exception gracefully in main().<br><br><em><strong>Hint:</strong> 
 * Define your own exception class extending Exception.</em>
 */
import java.util.Scanner;
class InsufficentFundsException extends Exception {
	InsufficentFundsException (String Message){
		super(Message);
	}
}
class paytmsend_mony{
	int balance=5000;
	public void sendMoney(int amount) throws InsufficentFundsException {
		if (amount>balance) {
			throw new InsufficentFundsException("Insufficient Balance....");
		}
		else {
		balance=balance-amount;
		System.out.println("Payment is Succesfully!......");
		System.out.println("remaining Balaance : "+balance);
		}
		}
	public int nextInt() {
		// TODO Auto-generated method stub
		return 0;
	}
}
public class Paytm_likeapp {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		paytmsend_mony p=new paytmsend_mony();
		System.out.println("Enter Amount To Send: ");
		int amount=sc.nextInt();
		try {
			p.sendMoney(amount);
		}catch(InsufficentFundsException e){
			System.out.println("Transection : Faild "+e.getMessage());
		}
	}

}
