/*1.Create a custom exception class called OutOfStockException for a 
 * Flipkart-style shopping cart, which should extend Exception and 
 * display a message when the requested quantity of a product exceeds 
 * available stock.
 */
import java.util.Scanner;
class OutofStockException extends Exception {
	OutofStockException(String Message){
		super(Message);
	}
}
class shopping_cart{
	int laptop_stock = 12;
	public void buyproduct(int product) throws OutofStockException{
		if(product>laptop_stock) {
			throw new OutofStockException("Recuest quantity Exceed availabal stock.");
		}else {
			laptop_stock=laptop_stock-product;
			System.out.println("Product Ordear Susscesfuly.");
			System.out.println("remaining Quantity : "+laptop_stock);
		}
	}
}
	

public class flipcart_outofstocck_exceprtion {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		shopping_cart p=new shopping_cart();
      System.out.print("Enter quantity your order : ");
      int q=sc.nextInt();
      try {
    	  p.buyproduct(q);
      }catch(OutofStockException e) {
    	  System.out.println("Ordear faild : "+e.getMessage());
      }
	}

}
