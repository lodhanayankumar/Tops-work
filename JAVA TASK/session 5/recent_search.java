/*1.Declare and initialize a String array called recentSearches to 
 * store the last 10 search terms a user entered in a Flipkart-style 
 * app, then print each term using a for loop
 */
public class recent_search {

	public static void main(String[] args) 
	{
       String[] recentSearches= {"Smart Phone","Laptop","wild stone perfume","M size Shirt"
    		   ,"Table lamp","Titan Watch","Face Wash","18 hearb soap","Almond","Key board"};
       System.out.println("---- last searches --- :");
       
       for(int i=0;i<recentSearches.length;i++)
       {	   
	   System.out.println(i+ ". "+recentSearches[i]);
	   }
	}

}
