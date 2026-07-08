import java.util.HashMap;
import java.util.Map;

public class map_instagramusear {

    public static void main(String[] args) {

        HashMap<String, Integer> user = new HashMap<>();

        user.put("nayan01", 12455);
        user.put("amit0012", 1452);
        user.put("rahul45", 3500);
        user.put("priya99", 2800);
        user.put("amit007", 5000);
        user.put("neha202", 5000);

        int max_follower = 0;

        // Find maximum followers
        for (int follower : user.values()) {
            if (follower > max_follower) {
                max_follower = follower;
            }
        }

        System.out.println("Username(s) with highest followers:");

        // Print all users having maximum followers
        for (Map.Entry<String, Integer> entry : user.entrySet()) {
            if (entry.getValue() == max_follower) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}