/*2.Write a Java method processPayment in a class called PaymentHandler 
 * that simulates a PhonePe payment. Use multiple catch blocks to handle 
 * NumberFormatException (for invalid amount input), 
 * InsufficientFundsException (if balance is too low), and a 
 * generic Exception for any other errors. Print a different error 
 * message for each case.
 */
class inSufficientBalance extends Exception {
	inSufficientBalance(String Message){
		super(Message);
	}
}
class PaymentHandler{
	int balance = 6000;
	public void processPayment(String amount) {
	try {
		int Payamount=Integer.parseInt(amount);
		if(Payamount > balance) {
			throw new inSufficientBalance("Balance is inSuficient..");
		}
		
		balance -= Payamount;
		System.out.println("Payment Succesful...\n");
		System.out.println("remaining balance : "+balance);
	}catch(NumberFormatException e) {
		System.out.println("Error: invalid Formate.");
	}catch(inSufficientBalance e)
	{
		System.out.println("Error: "+e.getMessage());
	}catch(Exception e) {
		System.out.println("Something went to wrong");
	}
	}
}
public class Phonepay_simulation_paymenthendlar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentHandler p=new PaymentHandler();
		p.processPayment("4200");
		p.processPayment("avnn");
		p.processPayment("8000");
	}

}
