/*3.Create an abstract class called UPITransaction with an abstract method processTransaction(double amount).
 *  Then, make two subclasses: PaytmTransaction and PhonePeTransaction, each providing their 
 *  own implementation of processTransaction that prints which app is processing the amount.
 */
abstract class UPITransactio_n{
	abstract void processTransaction(double amount) ;
}
class PaytmTransaction extends UPITransactio_n{
	@Override
	void processTransaction(double amount) {
		System.out.println("Paytm is Process ₹ "+amount);
	}
}
class PhonePeTransaction extends UPITransactio_n  {
	@Override
	void processTransaction(double amount) {
		System.out.println("Paytm is Process ₹ "+amount);
	}
}
public class UpiTransaction {

	public static void main(String[] args) {

		UPITransactio_n U1= new PaytmTransaction();
		UPITransactio_n U2=new PaytmTransaction();
		U1.processTransaction(500);
		U2.processTransaction(1250);
		
	}

}
