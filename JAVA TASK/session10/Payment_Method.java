/*1.Create a base class PaymentMethod with a topUp(double amount) method, 
 * then create three subclasses: CardPayment, UpiPayment, and CryptoPayment, 
 * each overriding topUp() to print a different message indicating 
 * the payment method used.
 */
class PaymentMethod{
	
	void topup(double amount) {
	System.out.println("payment in proccesing!..... ");
	}
}
class CardPayment extends PaymentMethod{
	@Override
	void topup(double amount) {
      System.out.println("₹ "+amount+" added using Card.");		
	}
}
class UpiPayment extends PaymentMethod{
	@Override
	void topup(double amount) {
		System.out.println("₹ "+amount+" added using Upi.");
	}
}
class CryptoPayment extends PaymentMethod{
	@Override
	
		void topup(double amount) {
			System.out.println("₹ "+amount+" added using CryptoPayment");
		}
	
}
 

public class Payment_Method {

	public static void main(String[] args) {
 
		CardPayment card =new CardPayment();
		UpiPayment upi=new UpiPayment();
		CryptoPayment crypto=new CryptoPayment();
		card.topup(50000);
		upi.topup(15800);
		crypto.topup(175000);
	}

}
