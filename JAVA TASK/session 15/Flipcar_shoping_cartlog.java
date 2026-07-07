/*3.Simulate a Flipkart shopping cart log: use FileOutputStream to append a line like 'Added: Redmi 
 * Note 12 - Rs. 12999' to a file named cartlog.txt every time you call a function addToCart().
 */
import java.io.FileOutputStream;
import java.io.IOException;

class shopingcart{
	public void addtocart(String productname, int price) {
		try {
		FileOutputStream fos = new FileOutputStream("cartlog.txt",true);
		String data ="Added: "+productname+"- Rs. "+price+"\n";
		fos.write(data.getBytes());
		System.out.println("Product added in cart");
		
		}catch(IOException e) {
			System.out.println("Error : "+e.getMessage());
		}
		}
}
public class Flipcar_shoping_cartlog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     shopingcart sp =new shopingcart();
     sp.addtocart("Redmi Note 12", 12999);
     sp.addtocart("samsung galaxy M15", 19000);
     sp.addtocart("oppo A 56", 21000);
	}

}
