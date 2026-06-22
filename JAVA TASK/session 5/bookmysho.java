/*4.Simulate a BookMyShow movie seat layout using a 2D char array 
 * (5 rows, 6 columns) where 'A' means available and 'B' means booked.
 *  Write code to count and print the number of available seats.
 *  <br><br><em><strong>Constraint:</strong> Do not use any external 
 *  libraries or ArrayList.</em>
 */

public class bookmysho {

	public static void main(String[] args) {
	String[][] seats= {
			{"A","B","B","B","B"},
			{"A","B","B","A","B"},
			{"A","B","A","A","A"},
			{"B","A","B","B","A"},
			{"B","A","A","A","B"},
			{"A","A","B","A","B"}
	};
	int count=0,sum=0;
	for(int i=0;i<seats.length;i++)
	{
		System.out.print("R" + (i + 1) + " | ");
		for(int j=0;j<seats[i].length;j++)
		{
			 System.out.print(seats[i][j] + "   ");
			if(seats[i][j].equals("A")) {
				count++;
			}sum++;
		}System.out.println();
	}
	System.out.println("Total seats = " + sum);
	 System.out.println("Available seats = " + count);
	}
}
