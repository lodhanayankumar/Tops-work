/*4.Write a Java interface called Searchable with a method search(String keyword). Implement this 
 * interface in a MovieLibrary class that stores an array of movie names, and returns all movies 
 * containing the keyword in search().
 */
interface searchableinterface{
	void search(String keyword);
}
class MovieLibrary implements searchableinterface{
	String[] movie = {
			"RRR","BAHUBALI","KESARI","BHOT BANGALA","BATMAN","SPIDERMAN","KANCHANA"
	};
	@Override
	public void search(String keyword) {
		System.out.println("Search Result : ");
		for(String movies: movie) {
			if(movies.toLowerCase().contains(keyword.toLowerCase())){
				System.out.println(movies);
			}
		}
	}
}
public class Searchable {

	public static void main(String[] args) {
       MovieLibrary m=new MovieLibrary();
       m.search("man");
	}

}
