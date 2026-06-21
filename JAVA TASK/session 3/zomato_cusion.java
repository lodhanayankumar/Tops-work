/*3.Build a Java program called ZomatoCuisineFilter that takes a 
 * string input for cuisine ('Indian', 'Chinese', 'Italian', 'Mexican')
 *  and uses a switch statement to print a list of 2-3 sample 
 *  restaurants for the selected cuisine. Print 'Cuisine Not Found' 
 *  for any other input.
 */
import java.util.Scanner;

public class zomato_cusion {

	public static void main(String[] args) {
       Scanner obj = new Scanner(System.in);
       System.out.print("Enter cusine type : ");
       String Type = obj.next();
       switch(Type) {
       case "Indian":
    	   System.out.println("1. malhar indian veg cuisine.");
    	   System.out.println("2. murugn south indian cuisine.");
    	   System.out.println("3. mahadev Nourth indian cuisine style");
          break;
       
       case "Chinese":
    	   System.out.println("1.great wall chinese cuisine");
    	   System.out.println("2.shine chinese cuisine");
    	   System.out.println("3.wang lean chinese cuisine");
           break;
       
       case "Italian":
    	   System.out.println("1.mount howk Italian cuisine");
    	   System.out.println("2.melony Italian cuisine");
    	   System.out.println("3.benzamin Italian cuisine");
           break;
       
       case "Mexican":
    	   System.out.println("1.wilshan wall Mexican cuisine");
    	   System.out.println("2.emily Mexican cuisine");
    	   System.out.println("3.robert d' Mexican cuisine");
    	   break;
       
       default :
    	   System.out.println("Cuisine Not Found");
       break;
	}

   }
}