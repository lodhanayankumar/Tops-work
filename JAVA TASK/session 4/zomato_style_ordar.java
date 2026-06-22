/*2.Simulate a Zomato-style order summary: Given an array of order 
 * amounts for a month, use a while loop to calculate and print the 
 * total amount spent
 */

public class zomato_style_ordar {

	public static void main(String[] args) {
       double[] spent_amount = {250.25, 156.80, 500.00, 806.20,379.00, 215.00, 690.25, 800.50};
       double total_spent=0.00;
       int i=0;
       while(i<spent_amount.length)
       {
           total_spent +=spent_amount[i] ;
    	   i ++;
       }
       System.out.print("Total amount Spent : "+total_spent);
	}

}
