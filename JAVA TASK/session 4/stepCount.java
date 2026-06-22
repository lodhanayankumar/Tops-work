/*1.Write a Java program using a for loop to display the daily step 
 * count for each day of a week, where the step counts are stored in 
 * an array.
 */
import java.util.Scanner;

public class stepCount {

	public static void main(String[] args) {
       Scanner obj = new Scanner(System.in);
       String[] day = {"Monday","Tuseday","wenesday","thusday","Friday","Sturday","Sunday"};
       System.out.print("How many day step count : ");
       int d = obj.nextInt();
       int[] step = new int[d];
       System.out.println("Enter steps : ");
       for(int j=0;j<d;j++)
       {
    	   step[j] = obj.nextInt();
       }
       for(int i=0;i<d;i++)
       { 
    	   System.out.println(day[i%7]+" :"+step[i]);
       }

	}
}