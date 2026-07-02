/*1.Create a Java class called InstaUsernameMasker that takes a username 
 * string (e.g., 'insta_rockstar123') and returns a masked version where 
 * all characters except the last 4 are replaced with '*'. For example, 
 * '***********r123'.
 */
import java.util.Scanner;
class InstaUsernameMasker{
	public static String maskusearname(String Username){
		if(Username.length()<=4) {
			return Username;
		}
		String mask = "";
		for(int i=0;i<Username.length()-4;i++) {
			mask+="*";
		}
		mask+=Username.substring(Username.length()-4);
	return mask;
	
}
public class instausername {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
       System.out.print("Enter user Name: ");
       String Username = sc.nextLine();
       String result=maskusearname(Username);
       System.out.println("Mask UsearName : "+result);
       
       
	}

}}
