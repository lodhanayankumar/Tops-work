/*3.Create a Java program that uses a do-while loop to repeatedly ask
 * the user to enter their favorite music artist until they type 
 * 'exit', then print how many artists they entered
 */

import java.util.Scanner;
public class Music_arist {

	public static void main(String[] args) {
		Scanner obj =new Scanner(System.in);
		System.out.println("Enter your Fevoriot Artist : ");
		String name;
		int count=0;
		do {
			name=obj.next();
			if (name.compareTo("exit")!=0)
				count++;  
		}while(name.compareTo("exit")!=0);
		System.out.print(count++);
	}

}
