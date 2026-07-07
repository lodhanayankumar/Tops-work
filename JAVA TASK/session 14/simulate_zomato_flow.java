/*
 * 3. Simulate a Zomato order flow where a user tries to place an order.
 * Throw and handle multiple exceptions:
 * 1. OutOfStockException - if the dish is unavailable.
 * 2. InsufficientFundsException - if wallet balance is too low.
 * 3. IllegalArgumentException - if the order amount is negative.
 * Catch each exception separately and display a user-friendly message.
 */

import java.util.Scanner;

// Custom Exception for Out of Stock
class OutOfStockException extends Exception {

    OutOfStockException(String message) {
        super(message);
    }
}

// Custom Exception for Insufficient Balance
class InsufficientFundsException extends Exception {

    InsufficientFundsException(String message) {
        super(message);
    }
}

// Zomato Class
class Zomato {

    int stock = 6;
    int balance = 800;

    // Method to place order
    public void placeOrder(int quantity, int amount)
            throws OutOfStockException, InsufficientFundsException {

        // Check for negative amount
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        // Check stock availability
        if (quantity > stock) {
            throw new OutOfStockException("Dish is unavailable.");
        }

        // Check wallet balance
        if (amount > balance) {
            throw new InsufficientFundsException("Wallet balance is low.");
        }

        // If all conditions are satisfied
        System.out.println("Order Placed Successfully.");
    }
}

// Main Class
public class simulate_zomato_flow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept order quantity
        System.out.print("Enter Order Quantity: ");
        int quantity = sc.nextInt();

        // Accept order amount
        System.out.print("Enter Order Amount: ");
        int amount = sc.nextInt();

        // Create object
        Zomato z = new Zomato();

        try {

            // Call method
            z.placeOrder(quantity, amount);

        }

        // Handle negative amount
        catch (IllegalArgumentException e) {
            System.out.println("Invalid Order: " + e.getMessage());
        }

        // Handle stock exception
        catch (OutOfStockException e) {
            System.out.println("Order Failed: " + e.getMessage());
        }

        // Handle wallet balance exception
        catch (InsufficientFundsException e) {
            System.out.println("Payment Failed: " + e.getMessage());
        }

        // Close Scanner
        sc.close();
    }
}