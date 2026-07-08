/*3.Add a login function that takes a username and password, validates them against the ArrayList of UserAccount 
 * objects, and prints 'Login successful' or 'Invalid credentials' accordingly.<br><br><em><strong>Hint:
 * </strong> Use a loop to search for the user and compare passwords using the getter method.</em>
 */
import java.util.ArrayList;

class UserAccoun_t {
    private String username;
    private String password;

    // Constructor
    UserAccoun_t(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Task_miniproject03 {

    // Registration method
    public static void registerUser(ArrayList<UserAccoun_t> users, String username, String password) {

        // Check if username already exists
        for (UserAccoun_t user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Username already exists!");
                return;
            }
        }

        users.add(new UserAccoun_t(username, password));
        System.out.println("Registration Successful.");
    }

    // Login method
    public static void loginUser(ArrayList<UserAccoun_t> users, String username, String password) {

        for (UserAccoun_t user : users) {
            if (user.getUsername().equalsIgnoreCase(username)
                    && user.getPassword().equals(password)) {
                System.out.println("Login successful");
                return;
            }
        }

        System.out.println("Invalid credentials");
    }

    public static void main(String[] args) {

        ArrayList<UserAccoun_t> users = new ArrayList<>();

        // Register users
        registerUser(users, "Rahul", "1234");
        registerUser(users, "Priya", "abcd");

        // Login
        loginUser(users, "Rahul", "1234"); // Correct
        loginUser(users, "Priya", "1111"); // Wrong password
        loginUser(users, "Amit", "1234");  // Username not found
    }
}