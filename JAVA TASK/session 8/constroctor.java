/*1.Create a Java class called Product with three constructors: a default constructor, a parameterized 
 * constructor that takes name and price, and a copy constructor that copies another Product object. 
 * In your main method, create one Product using each constructor and print their details.
 */
class Product{
	String name;
	int price;
	//default constructor
	Product() {
		name="unckow";
		price=0;
	}
	//parameterize constructor
	Product(String name,int price){
		this.name=name;
		this.price=price;
	}
	//copy constructor
	Product(Product p){
		this.name=p.name;
		this.price=p.price;
	}
	//display method
	void display() {
		System.out.println("product name : "+name);
		System.out.println("Product price : "+ price);
	}
}
public class constroctor {

	public static void main(String[] args) {
		System.out.println("-------------");//Default constructor
		Product p1= new Product();	
		p1.display();
		System.out.println("-------------");//parameterize constructor
		Product p2=new Product("laptop",50000);
		p2.display();
		System.out.println("-------------");//copy constructor
		Product p3=new Product(p2);
		p3.display();

	}

}
