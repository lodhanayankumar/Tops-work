/*4.Build a nested loop that prints a table showing the number of 
 * likes received on Instagram posts for each week 
 * (4 weeks, 7 days per week).<br><br><em><strong>
 * Hint:</strong> Use an outer loop for weeks and an inner loop for 
 * days, and generate random like counts for each cell.</em>
 */
public class instagram_post {

	public static void main(String[] args) {
		
		for(int week=1;week<=4;week++)
		{
			System.out.println("week " +week);
			for(int day=1;day<+7;day++)
			{
				int like = (int)(Math.random() * 1000);
				System.out.println("Day"+day+" : "+like);
			}
			
		}
	}

}
