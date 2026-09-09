/*4.Display a dynamic list of all events on EventsList.jsp by fetching event data from the events table 
 * in your database and passing it from an EventListServlet to the JSP using request attributes
 * .<br><br><em><strong>Constraint:</strong> Use a JavaBean class named Event to represent each 
 * event in your list.</em>
 */

package servle;

public class Event0_04 {

    private int id;
    private String title;
    private String eventDate;
    private String description;
    private String username;

    public Event0_04() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
