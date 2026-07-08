/*3.Given a HashMap of Flipkart product names (String) and their prices (Integer), write code to filter 
 * and print only those products with a price above 1000 using an iterator.<br><br><em><strong>
 * Hint:</strong> Use entrySet() and Iterator to loop through the map and check each price.</em>
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class price_filter_flipcart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           HashMap<String, Double> product = new HashMap<>();
           product.put("Bad Sheet", 200.00);
           product.put("Laptop", 55000.00);
           product.put("Mouse", 700.00);
           product.put("Keyboard", 1200.00);
           product.put("Headphones", 1800.00);
           product.put("Pen Drive", 800.00);
           
          Iterator<Map.Entry<String, Double>> iterato = product.entrySet().iterator();
    while(iterato.hasNext()) {
    	Map.Entry<String, Double> entr =iterato.next();
    	if(entr.getValue()>1000){
    		System.out.println("Product Name : "+entr.getKey()+" || Price : "+entr.getValue());
    	}
    }
	}

}
