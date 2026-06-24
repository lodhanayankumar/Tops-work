/*4. Refactor the following code to use constructor chaining in the
 * class Playlist, which has three constructors: default,
 * one with name, and one with name and description.
 * Use 'this()' to avoid repeating code.
 */

class Playlist {
    String name;
    String description;

    // Default constructor
    Playlist() {
        this("My Playlist", "No Description");
    }

    // Constructor with name only
    Playlist(String name) {
        this(name, "No Description");
    }

    // Constructor with name and description
    Playlist(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Method to display playlist details
    void display() {
        System.out.println("Playlist Name : " + name);
        System.out.println("Description   : " + description);
        System.out.println();
    }
}

public class Refactor {
    public static void main(String[] args) {

        // Using default constructor
        Playlist p1 = new Playlist();
        p1.display();

        // Using constructor with name
        Playlist p2 = new Playlist("Workout Songs");
        p2.display();

        // Using constructor with name and description
        Playlist p3 = new Playlist(
                "Travel Songs",
                "Songs for long journeys");
        p3.display();
    }
}