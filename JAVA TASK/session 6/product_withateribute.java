/*1.Create a Java class named Product with two attributes: productName 
 * (String) and price (double). Create an object of Product in your 
 * main method and print its details.
 */
 class Product{
    	 String productName;
    	 double price;
    	 
     }
	
public class product_withateribute {
    
	public static void main(String[] args) {
		Product p = new Product();
		p.productName ="Laptop";
		p.price = 45299.9;
        System.out.println(p.productName+" : "+p.price);
	}

}
