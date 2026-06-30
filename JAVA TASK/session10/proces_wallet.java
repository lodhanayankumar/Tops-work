/*2.Write a method processWalletTopUp(PaymentMethod method, double amount) that accepts any PaymentMethod 
 * object and calls its topUp() method. Demonstrate dynamic method dispatch by passing objects of 
 * CardPayment, UpiPayment, and CryptoPayment to this method and observing which version of topUp() is 
 * called.
 */
class PaymentMethod{
	void topup(double amont) {
		System.out.println("Processing payment....");
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
		System.out.println("₹ "+amount+" added using Crypto.");
		}
}
public class proces_wallet {
           static void processWalletTopUp(PaymentMethod method, double amount) {
        	   method.topup(amount);
           }
          public static void main(String[] args) {
        	   processWalletTopUp(new CardPayment(),50000);
        	   processWalletTopUp(new UpiPayment(),17854);
        	   processWalletTopUp(new CryptoPayment(),196500);
           }
}
