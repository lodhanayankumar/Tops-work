/*1.Create a UserAccount class with private fields for username, password, and balance. Add public getter
 *  and setter methods for balance only, and write a constructor to initialize username and password.
 */
class UserAccount{
	private String username;
    private String password;
    private double balance;
    
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
    }
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
public class Task_miniprooject01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create UserAccount object
        UserAccount user = new UserAccount("nayan01", "abc123");

        // Set balance
        user.setBalance(5000);

        // Display balance
        System.out.println("Balance: ₹" + user.getBalance());
	}

}
