/*2.Build a Java program that uses a HashSet to store unique usernames for a Zomato-style food review app. 
 * Add at least 7 usernames, including 2 duplicates, and display all unique usernames.
 */
import java.util.HashSet;

public class zomato_style_hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashSet<String> usearname =new HashSet<>();
        usearname.add("man12");
        usearname.add("neha202");
        usearname.add("pavan457");
        usearname.add("gita124");
        usearname.add("nayan123");   
        usearname.add("rahul45");    
        usearname.add("vaisu00");
        usearname.add("endu_ranci88");
        usearname.add("rahul45");    
        usearname.add("neha202");
        System.out.println("unique usearname :");
        for(String user: usearname) {
        	System.out.println(user);
        }
	}

}
