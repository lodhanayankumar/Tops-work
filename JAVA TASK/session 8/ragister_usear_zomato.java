/*5. Imagine you are adding new ways to register users in a Zomato-style app.
 * Use method overloading in a Registration class to create multiple
 * registerUser methods:
 * 1. email only
 * 2. email and password
 * 3. email, password, and phone number
 */

class Registration {

    // Register user using only email
    void registerUser(String email) {
        System.out.println("User registered with Email: " + email);
        System.out.println();
    }

    // Register user using email and password
    void registerUser(String email, String password) {
        System.out.println("User registered with Email: " + email);
        System.out.println("Password: " + password);
        System.out.println();
    }

    // Register user using email, password, and phone number
    void registerUser(String email, String password, long phoneNumber) {
        System.out.println("User registered with Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println();
    }
}

public class ragister_usear_zomato {

    public static void main(String[] args) {

        // Create Registration object
        Registration user = new Registration();

        // Register with email only
        user.registerUser("nayan@gmail.com");

        // Register with email and password
        user.registerUser("nayan@gmail.com", "Nayan@123");

        // Register with email, password, and phone number
        user.registerUser("nayan@gmail.com", "Nayan@123", 9876543210L);
    }
}