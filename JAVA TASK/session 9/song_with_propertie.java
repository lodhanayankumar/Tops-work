/*1.Create a Java class called Song with properties title and artist, 
 * then create a subclass PremiumSong that adds an extra property 
 * lyricsAccess (boolean) to indicate if the user can view lyrics.
 */
class song{
	String title;
	String artist;
	song(String title, String artist){
            this.title=title;
            this.artist=artist;
}
	void display() {
		System.out.println("song title : "+title);
		System.out.println("song artist : "+artist);
	}
}
class PremiumSong extends song{
     boolean	lyricsAccess;
     PremiumSong(String title, String artist,boolean lyricsAccess){
    	 super(title,artist);
    	 this.lyricsAccess = lyricsAccess;
     }
     void display_lyrics() {
    	 display();
		System.out.println("lyricsAccess : "+lyricsAccess);
     }
}

public class song_with_propertie {

	public static void main(String[] args) {
      PremiumSong p1= new PremiumSong("kesariya","arjit singh",true);
      p1.display_lyrics();
		
	}

}
 