/*4.Explain in your own words how using multiple threads can help an app like Zomato process order updates, 
 * send notifications, and calculate delivery time in parallel without making the user wait. 
 * Give one real example for each operation.
 */
//Answer
/*Using multiple threads allows different tasks to run at the same time, so the user does not have 
 * to wait for one task to finish before another starts. In a Zomato app, one thread can update the 
 * order status (for example, "Order is being prepared"), another thread can send notifications 
 * (such as "Your order has been dispatched"), and a third thread can calculate the delivery time 
 * based on the delivery partner's location and traffic. Since these tasks run in parallel, 
 * the app becomes faster and more responsive, giving the user a better experience.
 */