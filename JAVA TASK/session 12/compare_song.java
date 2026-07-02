/*2.Write a Java program that compares two song titles (as Strings) entered by the user and prints whether 
 * they are exactly the same using the equals() method, and then prints their lexicographical order 
 * using compareTo().
 */
import java.util.Scanner;
class compare{
	public static String Song(String song1,String song2) {
		if((song1.toLowerCase()).equals(song2.toLowerCase())) {
			return "Both song is Same";
		}
		else
			return "Both song is Diffrent";
	}
}
public class compare_song {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Song1 : ");
		String s1 = sc.nextLine();
		System.out.print("Enter Song2 : ");
		String s2 = sc.nextLine();

		System.out.println(compare.Song(s1,s2));
	    int result = s1.compareTo(s2);
	    if(result==0) {
	    	System.out.println("Both Song is Equal.");
	    }
	    else if (result>0) {
	    	System.out.println("Lexicographical Order:\n1. "+s2+"\n2. "+s1);
	    }else
	    	System.out.println("Lexicographical Order:\n1. "+s1+"\n2. "+s2);
	    
	}

}
