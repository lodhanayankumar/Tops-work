/*4.Write a Java program that reads an array of transaction amounts and processes each one using a for 
 * loop and try-catch-finally. Print 'Transaction complete' in the finally block for every transaction, 
 * whether it succeeded or failed.
 */
import java.util.Scanner;
public class transection_amount {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter transection no. : ");
		int n=sc.nextInt();
		int[] amount= new int[n];
		System.out.println("Enter Transectin Amount : ");
		for(int i =0;i<n;i++) {
			amount[i]=sc.nextInt();
		}
		System.out.println("\nProcessing Transection... \n");
		
		for(int i=0;i<n;i++) {try {
			if(amount[i]<0) {
			throw new Exception("Invelid Transection Amount");
			}
			System.out.println("Transection of amount : "+amount[i]+" Succesfully");
		}catch (Exception e) {
			System.out.println("Transection Faild "+e.getMessage());
		}
		}
	}

}
