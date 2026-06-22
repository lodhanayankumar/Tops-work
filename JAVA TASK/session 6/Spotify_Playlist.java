/*2.Build a Java class called Playlist that represents a Spotify 
 * playlist with attributes: playlistName (String) and totalSongs 
 * (int). Add a method displayInfo() that prints both attributes in 
 * a user-friendly format.
 */
class Playlist{
	String playlistName;
	int totalSongs;
	
	public void displayInfo() {
		
		System.out.println("playlist name : "+playlistName+" "+"\nTotal Song : "+totalSongs);
	}
}
public class Spotify_Playlist {

	public static void main(String[] args) {
	  Playlist p = new Playlist();
	 p.playlistName = "MALHAR";
		p.totalSongs = 102;
	  p.displayInfo();
	}

}
