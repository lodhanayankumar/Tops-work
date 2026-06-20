import java.util.Scanner;
public class zomato_wallet {

	public static void main(String[] args) {
		double a;
		Scanner obj = new Scanner(System.in);
		System.out.print("Add Balance : ");
		a =obj.nextDouble();
		if(a>500)
		{
			double y=0;
			y = a/10;
			System.out.print("Total Balance = "+(a+y));
		}else
			System.out.println("Total Balance = "+ a);
		

	}

}

//Write a Java program that takes a user's Zomato wallet 
//balance (double) and applies a 10% cashback if the balance
//is above ₹500, otherwise no cashback. Use arithmetic and 
//relational operators to calculate and display the final balance.