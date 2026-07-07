/*2.Read the playlist.txt file using FileReader and display each song name in the console with its line 
 * number, like '1. Blinding Lights'.
 */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fileread_playlistsong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
       FileReader fr =new FileReader("playlist.txt");
	   BufferedReader br= new BufferedReader(fr);
	   
	   String song;
	   int Lineno = 1;
	   while((song=br.readLine())!=null) {
		   System.out.println(Lineno+". "+song);
		   Lineno++;
	   }
	   br.close();
	   fr.close();
		}catch(IOException e) {
			System.out.println("Error : "+e.getMessage());
		}

}
}