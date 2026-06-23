/*4.Create a class called InstaProfile with instance variables username and followers, and a method 
 * increaseFollowers(int count) that adds to followers and prints the updated count.
 */
class instaprofil{
	String username;
	int followers;
	public instaprofil(String name,int follo) {
		username = name;
		followers=follo;
		System.out.println(name+" : "+follo);
	}
	void increaseFollowers(int count) {
		count = followers+ count;
		System.out.println(username + " : "+ count);
	}
}
public class instaProfile {

	public static void main(String[] args) {
		instaprofil p = new instaprofil("nayankumar",150);
		System.out.println("After increase insta folloewrs : ");
       p.increaseFollowers(41);
	}

}
