/*4.Given a long WhatsApp message string, use substring() and length() 
 * to extract and print only the first 30 characters, followed by '...' 
 * if the message is longer than 30 characters.<br><br><em><strong>
 * Hint:</strong> Use message.length() to check the length before using 
 * substring().</em>
 */
import java.util.Scanner;
class message{
	public static String mas(String s1) {
		String dot="";
		if(s1.length()>30) {
		return s1.substring(0,30)+"...";}
		else 
			return s1;
		
	}
}
public class whatsapp_meseg {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your messages: ");
		String se1 =sc.nextLine();
		message m1=new message();
		System.out.println(m1.mas(se1));
		
        
	}

}
