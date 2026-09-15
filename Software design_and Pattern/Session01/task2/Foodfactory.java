/*2.Implement a Factory pattern for a FoodDeliveryApp where the FoodFactory class creates objects of Pizza, Burger, or 
 * Biryani based on a string input. Each food class should have an order() method that prints a unique message.
 */

package Task1;

interface Food{
	void order();
}

class Pizza implements Food{
	@Override
	public void order() {
		System.out.println("Baking Pizza...");	
		}
}
class Burger implements Food{
	@Override
	public void order() {
		System.out.println("Burger is ready..");
	}
}
class Biryani implements Food{
	@Override
	public void order() {
		System.out.println("Byriani is cooking with spices.");
	}
}

public class Foodfactory{
	//object manage
	public static Food createFood(String foodType) //Food: your interfacecreate || Food: a method that creates and returns a Food object.
	 { 
		if (foodType.equalsIgnoreCase("Pizza")) { 
			return new Pizza(); 
			} else if (foodType.equalsIgnoreCase("Burger")){ 
				return new Burger(); 
			} else if (foodType.equalsIgnoreCase("Biryani")) { 
				return new Biryani(); 
			} else { 
		        return null; 
		    } 
	}

   public static void main(String[] args) {
	 
	   Food food1 = Foodfactory.createFood("Pizza"); 
	   food1.order(); 
	   Food food2 = Foodfactory.createFood("Burger"); 
	   food2.order(); 
	   Food food3 = Foodfactory.createFood("Biryani"); 
	   food3.order(); 
	   }
}
