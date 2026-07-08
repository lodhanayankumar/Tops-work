/*2.Build a Flipkart-style cashback updater: Write a CashbackThread class that increases a user's 
 * cashback balance by Rs.10 every 10 seconds for 1 minute, then prints the final balance.
 */
class CashbackThread extends Thread{
	int balance= 0;
	
	@Override
	public void run() {
		for(int i=1;i<=6;i++) {
			balance = balance+10;
			System.out.println("Cashback Added: Rs.10");
			System.out.println("Current Balance Rs."+balance);
			try {
				Thread.sleep(10000);
			}catch(InterruptedException e) {
				System.out.println("Thread Interrupted.");
			}
		}
		System.out.println("\nFinal Cashback Balance: Rs."+balance); 
	}
}
public class Flipkart_Cashback_update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CashbackThread t =new CashbackThread();
		t.start();
		
	}

}
