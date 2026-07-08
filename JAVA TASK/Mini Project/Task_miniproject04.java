/*4.Implement a method addFunds(double amount) in UserAccount that increases the balance and records a 
 * transaction string (like 'Added ₹500') in a transaction history ArrayList. Display the updated balance 
 * and the latest transaction after each deposit.
 */
import java.util.ArrayList;

class User_Account {

    private String username;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    User_Account(String username) {
        this.username = username;
        this.balance = 0;
        transactionHistory = new ArrayList<>();
    }

    // Method to add funds
    public void addFunds(double amount) {
        balance += amount;

        // Record transaction
        transactionHistory.add("Added ₹" + amount);

        // Display updated balance
        System.out.println("Balance: ₹" + balance);

        // Display latest transaction
        System.out.println("Latest Transaction: "+ transactionHistory.get(transactionHistory.size() - 1)+"\n");
    }
}

public class Task_miniproject04 {

    public static void main(String[] args) {

        User_Account user = new User_Account("Rahul");

        user.addFunds(500);
        user.addFunds(1000);
        user.addFunds(250);
    }
}