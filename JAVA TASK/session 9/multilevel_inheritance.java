/*4.Create three classes: AppUser (base), VerifiedUser (extends AppUser), and CelebrityUser 
 * (extends VerifiedUser). In CelebrityUser, use the super keyword to call the parent constructor 
 * and print a welcome message including the user's name.
 *
 * Constraint:
 * Demonstrate multilevel inheritance and constructor chaining using super().
 */

// Base class
class AppUser {
	
	// Variable to store user name
	String Name;
	
	// Constructor of AppUser
	AppUser(String Name) {
		this.Name = Name;
	}
}

// Derived class from AppUser
class VerifiedUser extends AppUser {
	
	// Variable declaration
	String Name;
	
	// Constructor of VerifiedUser
	// Calls parent class constructor using super()
	VerifiedUser(String Name) {
		super(Name);
	}
}

// Derived class from VerifiedUser
class CelebrityUser extends VerifiedUser {
	
	// Variable declaration
	String Name;
	
	// Constructor of CelebrityUser
	// Calls parent class constructor using super()
	CelebrityUser(String Name) {
		super(Name);
		
		// Display welcome message
		System.out.println("Welcome Celebrity User " + Name);
	}
}

// Main class
public class multilevel_inheritance {

	public static void main(String[] args) {
		
		// Creating object of CelebrityUser
		// This demonstrates multilevel inheritance
		// and constructor chaining
		CelebrityUser User = new CelebrityUser("Mike Tyson");

	}
}