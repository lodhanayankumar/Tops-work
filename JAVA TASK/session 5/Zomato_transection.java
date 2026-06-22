/*3.Write a Java program that takes an array of 10 transaction amounts 
 * (double) representing recent Zomato orders and calculates the total 
 * spent, the minimum, and the maximum order value.
 */
public class Zomato_transection {

	public static void main(String[] args) {
        double[] amount= {800.0,452.25,920.0,742.25,655.50,120.00,358.50,654.50,741.6,998.4};
        double total=0,min=amount[0],max=amount[0];
        for(int i=0;i<amount.length;i++)
        {
        	total+=amount[i];
        		if(amount[i]>min)
        		{
        			min=amount[i];
        		}
        	    if(amount[i]<max)
        	    {
        	    	max=amount[i];
        	    }
        }
        System.out.println("Total spent amount : "+total);
        System.out.println("Minimum order value : "+min);
        System.out.println("Maximum order value : "+ max);
	}

}
