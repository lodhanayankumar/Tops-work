/*4.Design a basic MVC structure for a Movie Ticket Booking feature like BookMyShow: create Movie (Model), 
 * MovieController (Controller), and MovieView (View) classes. The controller should fetch movie data from 
 * the model and pass it to the view for display.<br><br><em><strong>Hint:</strong> Use simple console output 
 * for the view.</em>
 */

package task2;

public class MovieController104 {

    private Movie104 movie;
    private MovieView104 view;

    public MovieController104(Movie104 movie, MovieView104 view) {

        this.movie = movie;
        this.view = view;
    }

    public void showMovie() {

        view.displayMovie(movie);
    }
}