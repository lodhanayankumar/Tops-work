/*4.Design a basic MVC structure for a Movie Ticket Booking feature like BookMyShow: create Movie (Model), 
 * MovieController (Controller), and MovieView (View) classes. The controller should fetch movie data from the 
 * model and pass it to the view for display.<br><br><em><strong>Hint:</strong> Use simple console output for 
 * the view.</em>
 */

package task2;

public class MovieView104 {

    public void displayMovie(Movie104 movie) {

        System.out.println("----- Movie Details -----");
        System.out.println("Movie ID: " + movie.getId());
        System.out.println("Movie Name: " + movie.getName());
        System.out.println("Language: " + movie.getLanguage());
        System.out.println("Ticket Price: " + movie.getPrice());
    }
}