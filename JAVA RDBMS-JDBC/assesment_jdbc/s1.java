/* S1. You are building an order management system for a food delivery platform. Active
orders are stored in a HashMap<String, Order> keyed by order ID. A junior developer
proposes replacing this with an ArrayList<Order> because it 'keeps the code simpler.'
*/
package assesment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class order{
	String order_Id;
	String Name;
	String iteam;
	double price;
	int quan;
	public order(String order_Id,String Name,String iteam,int quan,double price) {
		this.order_Id=order_Id;
		this.Name=Name;
		this.iteam=iteam;
		this.price=price;
		this.quan=quan;
	}
	public String getOrder_Id(){
		return order_Id;
	}
	public void displayOrder() {
		System.out.println("Order ID : "+order_Id);
		System.out.println("Name : "+Name);
		System.out.println("Iteam : "+iteam);
		System.out.println("Quantity : "+quan);
		System.out.println("Price : "+price);
		System.out.println("-------------------------");
	}
}

public class s1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        HashMap<String, order> ord=new HashMap<>();
//        
//        ord.put("ORD101",new order("ORD101","NAYAN", "COLD COFFE",1,160.0 ));
//        ord.put("ORD102", new order("ORD102","PARTH","BURGER",1,99.0));
//        ord.put("ORD103",new order("ORD103","RIYA","PASTA",1,140.0));
//        ord.put("ORD104", new order("ORD104","MIT","GARLIC BREAD",1,85.0));
        
		ArrayList<order> ord = new ArrayList<>();
		ord.add(new order("ORD101","NAYAN", "COLD COFFE",1,160.0 ));
        ord.add(new order("ORD102","PARTH","BURGER",1,99.0));
        ord.add(new order("ORD103","RIYA","PASTA",1,140.0));
        ord.add(new order("ORD104","MIT","GARLIC BREAD",1,85.0));
		
        System.out.println("All Activte Order : ");
        for(order order : ord) {
        	order.displayOrder();
        }
        
  //      for(order order : ord.values()) {
  //    	order.displayOrder();
  //       }
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter process orderId : ");
        String searchId=sc.nextLine();
      
        boolean found = false;
        order removeOrder = null;
        for (order order : ord) {
            if (order.getOrder_Id().equals(searchId)) {
                System.out.println("\nOrder Found:");
                order.displayOrder();
                found = true;
                removeOrder = order;
                break;
            }
        }
        System.out.println("\nOrdear Search Id : "+searchId);
        if (!found) {
            System.out.println("Order Not Found.");
        } else {
            // Remove Order
            ord.remove(removeOrder);
        }

        System.out.println("\nRemaining Orders:");

        for (order order1 : ord) {
            order1.displayOrder();
        }
}
	
}

	
