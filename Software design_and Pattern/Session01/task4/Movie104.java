/*4.Design a basic MVC structure for a Movie Ticket Booking feature like BookMyShow: create Movie (Model), 
 * MovieController (Controller), and MovieView (View) classes. The controller should fetch movie data 
 * from the model and pass it to the view for display.<br><br><em><strong>Hint:</strong> Use simple console 
 * output for the view.</em>
 */

package task2;

public class Movie104 {

    private int id;
    private String name;
    private String language;
    private double price;

    public Movie104(int id, String name, String language, double price) {

        this.id = id;
        this.name = name;
        this.language = language;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public double getPrice() {
        return price;
    }
}