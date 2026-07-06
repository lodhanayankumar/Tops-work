/*1.Create a Java method withdrawAmount(int balance, int amount) that throws an exception if the withdrawal 
 * amount is greater than the balance, otherwise subtracts the amount and prints the new balance.
 */

public class withdraw_b {
	public static void withdrawAmount(int balance, int amount) throws Exception{
		if (amount>balance) {
			throw new Exception("Inceficient Balance! withdrawa; amount exceeds available balance.");
		}else {
			balance-=amount;
			System.out.println("Withdraval is succesful...");
			System.out.println("remaining balance : "+ balance);
		}
	}	
	public static void main(String[] args) {
      
		try {
			withdrawAmount(10000,4890);
			withdrawAmount(1000,4000);
			
		}catch(Exception a) {
			System.out.println("Exception: "+a.getMessage());
		}
	}

}
