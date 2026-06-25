/*5.Refactor the following code so that it uses the this keyword to clearly distinguish between class 
 * properties and method parameters: class Product { String name; Product(String name) { name = name; } }
 * <br><br><em><strong>Hint:</strong> The constructor should assign the parameter to the class property 
 * correctly.</em>
 */
class Product{
	String name;
	Product(String name){
		this.name=name;
	}
	void display() {
		System.out.println("product Name : "+name);
	}
}
public class classProperti_methodPoperties {

	public static void main(String[] args) {
		Product p = new Product("Laptop");
		p.display();
	}

}
