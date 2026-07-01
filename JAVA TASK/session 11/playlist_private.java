/*1.Create a Java class called Playlist with private fields: 
 * name (String), owner (String), and totalSongs (int). 
 * Add public getter and setter methods for each field, 
 * and write a main method to set and print all values.
 */
class Playlist{
	private String name;
	private String owner;
	private int totalSong;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setOwner(String owner) {
		this.owner=owner;
	}
	public String getOwner() {
		return owner;
	}
	public void setTotalSong(int totalSong) {
		this.totalSong=totalSong;
	}
	public int getTotalSong() {
		return totalSong;
	}
}
public class playlist_private {

	public static void main(String[] args) {

		Playlist p= new Playlist();
		p.setName("Hindi Song");
		p.setOwner("Arjit singh");
		p.setTotalSong(10);
		System.out.println("Palylist Name : "+p.getName());
		System.out.println("Owner : "+p.getOwner());
		System.out.println("Total Song : "+p.getTotalSong());
	}

}
