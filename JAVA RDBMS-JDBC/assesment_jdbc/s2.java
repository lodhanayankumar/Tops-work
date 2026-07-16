package assesment;

import java.util.Scanner;

// Custom Exception 1
class WalletBalanceException extends Exception {
    public WalletBalanceException(String msg) {
        super(msg);
    }
}

// Custom Exception 2
class PaymentGatewayTimeoutException extends Exception {
    public PaymentGatewayTimeoutException(String msg) {
        super(msg);
    }
}

// Custom Exception 3
class ItemUnavailableException extends Exception {
    public ItemUnavailableException(String msg) {
        super(msg);
    }
}

class PaymentService {

    public void processPayment(double walletBalance, double billAmount,
                               boolean gatewayTimeout,
                               boolean itemAvailable)
            throws WalletBalanceException,
                   PaymentGatewayTimeoutException,
                   ItemUnavailableException {

        if (walletBalance < billAmount) {
            throw new WalletBalanceException("Wallet balance is too low.");
        }

        if (gatewayTimeout) {
            throw new PaymentGatewayTimeoutException("Payment gateway timed out.");
        }

        if (!itemAvailable) {
            throw new ItemUnavailableException("Restaurant marked the item as unavailable.");
        }

        System.out.println("Payment Successful!");
    }
}

public class s2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Wallet Balance: ");
        double wallet = sc.nextDouble();

        System.out.print("Enter Bill Amount: ");
        double bill = sc.nextDouble();
        if(wallet<bill){
        	System.out.println("insufficient balance");
        	   sc.close();
        	    return;
       }else {   
        
        System.out.print("Payment Gateway Timeout? (true/false): ");
        boolean timeout = sc.nextBoolean();

        System.out.print("Item Available? (true/false): ");
        boolean available = sc.nextBoolean();

        PaymentService payment = new PaymentService();

        try {

            payment.processPayment(wallet, bill, timeout, available);

        } catch (WalletBalanceException e) {

            System.out.println(e.getMessage());

        } catch (PaymentGatewayTimeoutException e) {

            System.out.println(e.getMessage());

        } catch (ItemUnavailableException e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println("Thank you for using Food Delivery App.");

        }}

        sc.close();
    }
}