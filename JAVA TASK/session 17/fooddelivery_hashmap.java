/*1.Create a HashMap in Java to store 5 food delivery order IDs (String) as keys and their order amounts 
 * (Double) as values, then print all key-value pairs using an iterator.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class fooddelivery_hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       HashMap<String, Double> order =new HashMap<>(); 
		 order.put("ORD12201", 250.00);
		 order.put("ORD12202", 550.00);
		 order.put("ORD12203", 120.00);
		 order.put("ORD12204", 180.75);
	     order.put("ORD12205", 320.00);
	     order.put("ORD12206", 150.25);
	     Iterator<Map.Entry<String,Double>> itera =order.entrySet().iterator();
	     while(itera.hasNext()) {
	    	 Map.Entry<String, Double> entry = itera.next();
	    	 System.out.println("Order Id : "+ entry.getKey()+" Amount Rs."+entry.getValue());
	     }
	}

}
