/*4.Design a basic MVC structure for a Movie Ticket Booking feature like BookMyShow: create Movie (Model), 
 * MovieController (Controller), and MovieView (View) classes. The controller should fetch movie data from 
 * the model and pass it to the view for display.<br><br><em><strong>Hint:</strong> Use simple console output 
 * for the view.</em>
 */
package task2;

public class MovieBookingApp104 {

    public static void main(String[] args) {

        Movie104 movie = new Movie104(101,"Pushpa 2", "Hindi", 250);
        
        MovieView104 view = new MovieView104();

        MovieController104 controller = new MovieController104(movie, view);
        
        controller.showMovie();
    }
}