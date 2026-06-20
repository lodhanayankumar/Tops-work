//5.Demonstrate both implicit and explicit type casting in 
//Java by converting a float rating (e.g., 4.7) to an int 
//and then back to double. Print all values to show the effect 
//of casting.<br><br><em><strong>Constraint:</strong> Do not 
//use any external libraries; use only standard Java casting syntax.
import java.util.Scanner;

public class implicit_explicit {

	public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      System.out.print("enter float value : ");
      float A = obj.nextFloat();
	  
      int b  = (int)A;
      double c = b;
      
      System.out.println("float value : "+A);
      System.out.println("float convert in to int : " +b);
      System.out.println("int value convert into adouble : " +c);
	}

}
