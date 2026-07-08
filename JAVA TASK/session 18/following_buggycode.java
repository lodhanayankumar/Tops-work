/*3.Given the following buggy code, fix it so that it correctly starts a thread to print 'Background 
 * music check running...' every 3 seconds:<br><br>class MusicCheck implements Runnable 
 * { public void run() { while(true) { System.out.println("Background music check running..."); 
 * Thread.sleep(3000); } } }<br>public class Main { public static void main(String[] args) 
 * { MusicCheck mc = new MusicCheck(); mc.run(); } }<br><br><em><strong>Hint:</strong> 
 * Ensure the thread is actually started and handle any exceptions properly.</em>
 */
// Class that implements the Runnable interface
class MusicCheck implements Runnable {

    // Code that will run inside the thread
    @Override
    public void run() {

        // Infinite loop
        while (true) {

            // Print the message
            System.out.println("Background music check running...");

            try {
                // Pause the thread for 3 seconds
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // Handle interruption
                System.out.println("Thread Interrupted.");
            }
        }
    }
}

// Main class
public class following_buggycode {

    public static void main(String[] args) {

        // Create object of Runnable class
        MusicCheck mc = new MusicCheck();

        // Create a Thread object
        Thread t = new Thread(mc);

        // Start the thread
        t.start();
    }
}