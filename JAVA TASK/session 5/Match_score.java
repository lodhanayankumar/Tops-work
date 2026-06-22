/*2.Create a 2D integer array called matchScores to represent the runs 
 * scored by 5 IPL teams in their last 3 matches. Fill it with sample 
 * values and display the scores in a table format using nested loops.
 * <br><br><em><strong>Hint:</strong> Use matchScores[team][match] 
 * to access each score.</em>
 */
public class Match_score {

	public static void main(String[] args) {
       int[][] matchScores = {{128,156,110},{174,98,150},{198,144,163},
    		   {174,183,122},{201,87,175}};
       System.out.println("Score card");
       for(int i=0 ;i < matchScores.length;i++)// i is team name
       {
    	   System.out.print("Team : "+(i+1)+": ");
    	   for(int r=0; r< matchScores[i].length; r++)//r use for team i score
    	   {
    		   System.out.print(matchScores[i][r]+"\t");
    		   
    	   }
    	   System.out.println();// use moving next line after 1st team score add
       }
       
       
	}

}
