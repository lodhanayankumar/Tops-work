/*5.Create a Java method maskWalletID(String walletID) that takes a wallet ID like 'WAL12345678' 
 * and returns it in the format '***5678' (masking all but the last 4 digits). Use StringBuffer 
 * for the masking logic.<br><br><em><strong>Constraint:</strong> Do not use any external libraries 
 * or regular expressions.</em>
 */
import java.util.Scanner;
class Mask{
	public static String maskWalletID(String walletID) {
		StringBuffer sb = new StringBuffer(walletID) ;
			for(int i=0;i<sb.length()-4;i++) {
				sb.setCharAt(i,'*');
			}
		return sb.toString();
	}
}
public class maskWallet {

	public static void main(String[] args) {
		Scanner sc =new  Scanner(System.in);
		System.out.println("Enter your WlletiD :");
		String wall =sc.nextLine();
		System.out.println("mask wallet id : "+ Mask.maskWalletID(wall));
	}

}
