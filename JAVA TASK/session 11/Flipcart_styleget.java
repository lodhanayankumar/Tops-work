/*2.Build a Flipkart-style Product class with fields: productName (String), price (double), 
 * and discount (double). Make all fields private, provide public getters/setters, and 
 * add a method getFinalPrice() that returns price after applying discount.
 */
class Flip_cartStyle{
	private String productName;
    private double price;
    private double discount;
    public void setProductName(String productName) {
    	this.productName=productName;
    }
    public String getProductName() {
    	return productName;
    }
    public void setPrice(double price) {
    	this.price=price;
    }
    public double getPrice() {
    	return price;
    }
    public void setDiscount(double discount) {
    	this.discount=discount;
    }
    public double getDiscount() {
    	return discount;
    }
    public double getfinalPrice() {
    	return price-(price*discount/100);
    }
    
}
public class Flipcart_styleget {

	public static void main(String[] args) {
		Flip_cartStyle F= new Flip_cartStyle();
		F.setProductName("laptop");
		F.setPrice(50000);
		F.setDiscount(12.5);
		System.out.println("Product Name : "+F.getProductName());
		System.out.println("Price : "+F.getfinalPrice());
		System.out.println("Discount : "+F.getDiscount());
		System.out.println("--------------------------");
		System.out.println("Final Price : "+F.getfinalPrice());
	}

}
