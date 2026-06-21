/*2.Create a Java class MovieAgeGate that asks the user for their 
 * age and uses an if-else-if ladder to print 'Kids Section' if age 
 * < 13, 'Teen Section' if age is between 13 and 17, and 'Adult 
 * Section' if age is 18 or above. */

import java.util.Scanner;
public class MovieAge_gate {

	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter Person Age : ");
		int a = obj.nextInt();  // a is age variable taken by usear
		
		if(a<13) 
			System.out.println("Kids Section");
		else if(12<a && a<18)
		    System.out.println("Teen Section");
		else if(17<a && a<130)
			System.out.println("Adult Section");
		else
			System.out.println("kindly check enterd age.---Try agin.");
	}

}
