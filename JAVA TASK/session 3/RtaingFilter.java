/*5.Write a Java function filterByMinRating(int[] ratings, int minRating)
 *  that prints only those ratings from the array that are greater
 *  than or equal to minRating, similar to how Flipkart filters 
 *  products by rating using SQL WHERE clauses.<br><br><em><strong>
 *  Hint:</strong> Use a for loop with an if condition to filter and 
 *  print matching ratings.</em>
 */
import java.util.Scanner;
public class RtaingFilter {
// creat function
	public static void filterByMinRating(int[] ratings, int minRating) 
	{
		for(int i=0;i < ratings.length; i++)
		{
			if (ratings[i]>=minRating)
				System.out.println(ratings[i]+"\t");
		}
	}
	static void main(String[] args) 
	{
		Scanner obj=new Scanner(System.in);
		int[] ratings = {1,2,5,4,4,3,1,2,0,5,2,0,5,5,3,1,3,5};//use in buit rating data 
		System.out.println("Enterd minimume rating : ");
		int minRating = obj.nextInt();
		filterByMinRating(ratings, minRating);//useing function
	}

}
