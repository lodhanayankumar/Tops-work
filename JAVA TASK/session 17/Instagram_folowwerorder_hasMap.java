/*4.Write a Java function that takes a HashMap of Instagram usernames (String) and their follower counts 
 * (Integer), sorts the entries by follower count in descending order, and prints the top 3 users.
 * <br><br><em><strong>Constraint:</strong> Do not use streams or third-party libraries for sorting.</em>
 */
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Instagram_folowwerorder_hasMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashMap<String, Integer> follower = new HashMap<>();

        follower.put("nayan01", 12455);
        follower.put("amit0012", 1452);
        follower.put("rahul45", 3500);
        follower.put("priya99", 2800);
        follower.put("amit007", 5000);
        follower.put("neha202", 5000);
   ArrayList<Map.Entry<String, Integer>> list =  new ArrayList<>(follower.entrySet());

   for(int i=0;i<list.size()-1;i++) {
	   for(int j=i;j<list.size();j++) {
		    if(list.get(i).getValue()< list.get(j).getValue()) {
		    	Map.Entry<String, Integer> temp=list.get(i);
		    	list.set(i, list.get(j));
		    	list.set(j,temp);
		    }
	   }
   }
   System.out.println("Top 3 user : ");
   for(int i=0;i<3;i++) {
	   System.out.println(list.get(i).getKey()+" : "+list.get(i).getValue());
   }
	}

}
