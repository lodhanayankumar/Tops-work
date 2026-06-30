/*4.Explain the difference between compile-time polymorphism (method overloading) and runtime 
 * polymorphism (method overriding) using a real-world example from apps like Paytm or PhonePe.
 * <br><br><em><strong>Hint:</strong> Think about how the same function name can do different things 
 * depending on the object type.</em>
 */
class payment{                                        //Compile-Time Polymorphism(Method Overloading)
	void reacharge(long mobileno) {
		System.out.println("Reacharge using Mobile Number.");
	}
	void reacharge(long mobileno,double reacharge) {
		System.out.println("Reacharge ₹ "+reacharge+" to "+mobileno);
	}
	void reacharge(long mobileno,double reacharge, String coupen) {
		System.out.println("Reacharge ₹ "+reacharge+" to "+mobileno+" using "+coupen);
	}
}
//runtime polymorphism (method overriding)
class reacharg_payment{                       //parent class
	void Topup(double amount) {
		System.out.println("reachareg in process.");
	}
}
class Upi_Payment extends reacharg_payment{        //child class
	@Override
	void Topup(double amount) {
		System.out.println("reacharg ₹ "+amount+" using Upi Payment");
	}
}
class Card_Payment extends reacharg_payment{       //child class
	@Override
	void  Topup(double amount) {
		System.out.println("reacharg ₹ "+amount+" using Upi Payment");
	}
}
class Crypto_Payment extends reacharg_payment{     //child class
	@Override
	void Topup(double amount) {
		System.out.println("reacharg ₹ "+amount+" using crypto Payment ");
	}
}
public class compile_timepoly {

	public static void main(String[] args) {
		//Compile-Time Polymorphism (Method Overloading)
       System.out.println(" compile-time polymorphism ");
		payment p= new payment();
		p.reacharge(9852634585L);
		p.reacharge(9574585674L,899);
		p.reacharge(7885964875L,599,"PROM10");
		System.out.println("\n runtime polymorphism ");
		
		//runtime polymorphism (method overriding)
		Card_Payment card=new Card_Payment();
		Upi_Payment upi =new Upi_Payment();
		Crypto_Payment crypto= new Crypto_Payment();
		card.Topup(536);
		upi.Topup(299);
		crypto.Topup(399);

	}

}
