/*3.Simulate a Flipkart-style wallet recharge: Store an array of PaymentMethod references, each 
 * pointing to a different subclass object (CardPayment, UpiPayment, CryptoPayment). 
 * Loop through the array and call topUp(500) on each to show runtime polymorphism in action
 */
class PaymentMethod{
	void topup(double amount) {
		System.out.println("Wallet reacharge of ₹ "+amount);
	}
}
class CardPayment extends PaymentMethod {
	@Override
	void topup(double amount) {
		System.out.println("wallet reacharge using Card ₹ "+amount);
	}
}
class UpiPayment extends PaymentMethod{
	@Override
	void topup(double amount) {
		System.out.println("wallet reacharge using Upi ₹ "+amount);
	}
}
class CryptoPayment extends PaymentMethod{
	@Override
	void topup(double amount) {
		System.out.println("wallet reacharge using Crypto ₹ "+amount);
	}
}

public class Flipcart_styleWallet {

	public static void main(String[] args) {
		
		PaymentMethod[] method = { new CardPayment(), new UpiPayment(), new CryptoPayment()};
		for(PaymentMethod method1:method) {
			method1.topup(500);
		}

	}

}
