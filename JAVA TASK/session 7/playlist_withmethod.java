/*1.Create a Java class named Playlist with a method addSong() that prints 'Song added to playlist' and another 
 * method checkSongCount() that prints the total number of songs added.
 */
class Playlist{
	int songCount;
	
	void Song_add(){
		System.out.println("Song added to playlist");
		songCount++;
	}
	void Song_count() {
		System.out.println("total song : "+songCount);
	}
}

public class playlist_withmethod {

	public static void main(String[] args) {
		Playlist p =new Playlist();
		p.Song_add();
		p.Song_add();
		p.Song_add();
		p.Song_add();
		p.Song_count();

	}

}
