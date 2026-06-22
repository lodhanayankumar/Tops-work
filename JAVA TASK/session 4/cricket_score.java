/*5.Write a Java program that iterates through an array of cricket
 *  scores (one per match) and skips any score below 50 using continue,
 *   but stops processing completely if a score of 200 is found using
 *   break.
 */
public class cricket_score {

	public static void main(String[] args) {
       int[] score = {10,50,40,45,84,76,95,195,126,0,65,200,174,201,265,42,78};
       
       for(int i=0;i<score.length;i++) {
       if(score[i] < 50)
       {
    	   continue;
       }
       if(score[i]==200)
       {
       break;
       }
       
       System.out.print(score[i]+"\t");
       }

}
}