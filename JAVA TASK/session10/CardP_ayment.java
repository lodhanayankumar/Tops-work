/*5.Refactor your CardPayment class so that it includes a cashback feature: override topUp() to print 
 * a special message if the amount is above 1000, simulating a promotional offer like those on 
 * Cred or Paytm.<br><br><em><strong>Constraint:</strong> Only modify CardPayment, 
 * not the base class or other subclasses.</em>
 */
class paymentMethod{
	void TOPup(double amount) {
	System.out.println("Payment in processing..");	
	}
}
class Cardpayment extends paymentMethod{
	@Override
	void TOPup(double amount) {
		if (amount>1000)
		System.out.println("your add ₹ "+amount+" congratulation you can Unlock CashBack using card 10% now your Balance ₹ "+(amount*0.1+amount));
		else
			System.out.println("your account recived ₹ "+amount+" using Card Payment.");
	}
}
class Upipayment extends paymentMethod{
	@Override
	void TOPup(double amount) {
		System.out.println("your account recived ₹ "+amount+ "using Upi Payment.");
	}
}
class Cryptopayment extends paymentMethod {
	@Override
	void TOPup(double amount) {
		System.out.println("your acoount recived ₹ "+amount+" using Upi Payment.");
	}
}
public class CardP_ayment {

	public static void main(String[] args) {
        paymentMethod[] m= {new Cardpayment(),new Upipayment(),new Cryptopayment()};
        for(paymentMethod m1: m) {
        	m1.TOPup(1001);
        }
		
	}

}
