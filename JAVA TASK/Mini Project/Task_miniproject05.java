/*5.Build a spendFunds(double amount) method for UserAccount that deducts the amount only if the balance is 
 * sufficient, updates the transaction history, and prevents the balance from going negative.
 * <br><br><em><strong>Constraint:</strong> Show an error message if the user tries to spend more than their 
 * balance.</em>
 */
import java.util.ArrayList;

class U_serAccount {

    private String username;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    U_serAccount(String username) {
        this.username = username;
        balance = 0;
        transactionHistory = new ArrayList<>();
    }

    // Add funds
    public void addFunds(double amount) {
        balance += amount;
        transactionHistory.add("Added ₹" + amount);

        System.out.println("Balance: ₹" + balance);
        System.out.println("Latest Transaction: " +
                transactionHistory.get(transactionHistory.size() - 1));
    }

    // Spend funds
    public void spendFunds(double amount) {

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Spent ₹" + amount);

            System.out.println("Balance: ₹" + balance);
            System.out.println("Latest Transaction: " +
                    transactionHistory.get(transactionHistory.size() - 1));
        } else {
            System.out.println("Error: Insufficient Balance!");
        }
    }
}

public class Task_miniproject05 {

    public static void main(String[] args) {

        U_serAccount user = new U_serAccount("Rahul");

        user.addFunds(1000);

        user.spendFunds(300);

        user.spendFunds(800); // More than available balance
    }
}