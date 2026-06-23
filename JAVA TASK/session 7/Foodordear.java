/*3.Write a class called FoodOrder with methods addItem(String itemName) and getOrderSummary() that keeps 
 * track of items added and displays the full order when called.
 */
class FoodOrder{
	String order= " ";
	int count=1;
	void addItem(String itemName) {
		order = order+count +". "+ itemName +"\n";
		count++;
		System.out.println(itemName+" is add to order");
	}
	void getOrderSummary() {
		System.out.println("your full order list : \n"+ order);
	}
}
public class Foodordear {

	public static void main(String[] args) {
		FoodOrder F = new FoodOrder();
		F.addItem("rice");
		F.addItem("paneer tikka");
		F.addItem("Tandori roti");
		F.addItem("ButterMilk");
		F.getOrderSummary();

	}

}
