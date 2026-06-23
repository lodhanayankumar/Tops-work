/*5.Relate the concept of classes and methods to a real app you use: Pick any one 
 * (like Zomato, Flipkart, Instagram) and list 3 possible classes (as if you were coding the app) and 
 * for each, write 2 method names that would perform CRUD-like operations.
 */
class user{
	void creat_account() {
		System.out.println("Status: user Account Created.");
	}
	void delete_account() {
		System.out.println("Status: User Account Delete.");
	}
}
class post{
	void add_post() {
		System.out.println("Status: Post Added Sucssesfuly.");
	}
	void remove_post() {
		System.out.println("Stutus: Post Remove Sucssesfuly.");
	}
}
class comment {
	void add_comment() {
		System.out.println("Status: Comment Added.");
	}
	void delete_comment() {
		System.out.println("Status: Comment Deleted.");
	}
}
public class Instagram_app {

	public static void main(String[] args) {
         
		user acc = new user();
		post po = new post();
		comment co =new comment();
		acc.creat_account();
		acc.delete_account();
		po.add_post();
		po.remove_post();
		co.add_comment();
		co.delete_comment();
	}

}
