import java.util.Scanner;

public class whatsapp_messege {

	public static void main(String[] args) {
        int A;// unread messege number
        String status;//stause of unread messeges
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter total Number of Messeges : ");
        A = obj.nextInt();
        status = (A ==0 )? "NO unread messeges":
        	     (A<=10)?"Few unread messeges":
        	     "Too many unread messege";
        System.out.println(status);
	}

}
