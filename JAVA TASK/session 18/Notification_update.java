/*1.Create a Java class called NotificationUpdater that implements the 
 * Runnable interface. In the run() method, print 'You have new 
 * notifications!' every 5 seconds, three times in total.<br><br><em><strong>
 * Hint:</strong> Use Thread.sleep(5000) inside the loop to pause for 5 
 * seconds.</em>
 */
class NotificationUpdater implements Runnable{
	
	@Override
	public void run(){
		for(int i=0;i<3;i++) {
			System.out.println("You Have New Notification.");
			try {
				Thread.sleep(5000);
			}catch(InterruptedException e) {
				System.out.println("Thread Interrupt.");
			}
		}
	}
}
public class Notification_update {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       NotificationUpdater no =new NotificationUpdater();
       Thread T =new Thread(no);
       T.start();
	}

}
