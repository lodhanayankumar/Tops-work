/*3.Write a class UserProfile with a method displayProfile() that prints the user's name. 
 * Create two subclasses: InfluencerProfile (adds followers property) and BrandProfile 
 * (adds brandName property). Demonstrate hierarchical inheritance by creating objects of both subclasses 
 * and calling displayProfile().
 */

// Parent class
class UserProfile {
	
	// Variable to store user name
	String Name;
	
	// Constructor to initialize name
	UserProfile(String Name) {
		this.Name = Name;
	}
	
	// Method to display user profile
	void displayProfile() {
		System.out.println("User Name : " + Name);
	}
}

// Child class 1 - InfluencerProfile inherits UserProfile
class InfluencerProfile extends UserProfile {
	
	// Variable to store number of followers
	int followers;
	
	// Constructor to initialize name and followers
	InfluencerProfile(String Name, int followers) {
		super(Name);
		this.followers = followers;
	}
}

// Child class 2 - BrandProfile inherits UserProfile
class BrandProfile extends UserProfile {
	
	// Variable to store brand name
	String BrandName;
	
	// Constructor to initialize name and brand name
	BrandProfile(String Name, String BrandName) {
		super(Name);
		this.BrandName = BrandName;
	}
}

public class UserProfil {

	public static void main(String[] args) {
		
		// Creating object of InfluencerProfile
		InfluencerProfile p1 = new InfluencerProfile("virat kohali", 50000);
		
		// Calling inherited method and displaying followers
		p1.displayProfile();
		System.out.println("Follower : " + p1.followers);
		
		System.out.println();
		
		// Creating object of BrandProfile
		BrandProfile b1 = new BrandProfile("Admin", "Nike");
		
		// Calling inherited method and displaying brand name
		b1.displayProfile();
		System.out.println("Brand Name : " + b1.BrandName);
	}
}