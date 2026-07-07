/*1.Use FileWriter to create a file named playlist.txt and write the names of 5 songs you listen to on 
 * Spotify, each on a new line.
 */
import java.io.FileWriter;
import java.io.IOException;
public class Filewrite_playlistsong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileWriter fw= new FileWriter("playlist.txt");
			fw.write("perfact\n");
			fw.write("Belive\n");
			fw.write("Shape of You\n");
			fw.write("Heat wave\n");
			fw.write("kesariya \n");
			fw.close();
			System.out.println("Song Written in Succesful in playlist.txt");
		}catch(IOException e) {
			System.out.println("Error : "+e.getMessage());
		}
	}

}
