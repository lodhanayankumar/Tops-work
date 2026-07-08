/*2.Write a Java program that uses an ArrayList to temporarily store multiple UserAccount objects. Implement 
 * a registration function that checks if the username already exists before adding a new user.
 */
import java.util.ArrayList;

 class UserAccount01 {
    String username;
    String email;

    // Constructor
    UserAccount01(String username, String email) {
        this.username = username;
        this.email = email;
    }
    // Display user details
    void display() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email+"\n");
    }
}

 public class Task_miniproject02 {

	// Registration method
	public static void registerUser(ArrayList<UserAccount01> users, String username, String email) {

	    // Check if username already exists
	    for (UserAccount01 user : users) {
	        if (user.username.equalsIgnoreCase(username)) {
	            System.out.println("Registration Failed! Username '" + username + "' already exists.");
	            return;
	        }
	    }    
	    // Add new user
	    users.add(new UserAccount01(username, email));
	    System.out.println("User '" + username + "' registered successfully.\n");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ArrayList<UserAccount01> users = new ArrayList<>();

	        // Register users
	        registerUser(users, "Rahul015", "rahul@gmail.com");
	        registerUser(users, "Priya126", "priya@gmail.com");
	        registerUser(users, "Rahul015", "rahul123@gmail.com"); 
	        registerUser(users, "Rahul114", "rahul13@gmail.com");
	        // Display all registered users
	        System.out.println("\nRegistered Users:");
	        for (UserAccount01 user : users) {
	            user.display();
	        }
	}

}
