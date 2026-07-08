/*2.Build a LinkedHashMap to store 4 recent songs played on Spotify, where the key is the song title and 
 * the value is the artist name. Display the songs in the order they were added.
 */
import java.util.LinkedHashMap;
import java.util.Map;
public class recent_song_hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    LinkedHashMap<String,String> song = new LinkedHashMap<>();
    song.put("kesariya", "Arjit singh");
    song.put("Lag Ja Gale", "Lata Mangeshkar");
    song.put("Dil De Diya Hai", "Anand Raj Anand");
    song.put("Believer", "Imagine Dragons");
	
    System.out.println("Recent Played song :");
    for(Map.Entry<String, String> entry : song.entrySet()) {
    	System.out.println("Song Title : "+entry.getKey()+"|| artist name : "+entry.getValue());
    }
		
	}

}
