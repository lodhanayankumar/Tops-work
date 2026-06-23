/* 
2. Define a class called MovieTicket with an instance variable price 
and a static variable totalTickets.
Write methods to increase total tickets and display the current total.
*/

class MovieTicket {

    // Instance variable: each object can have a different price
    double price;

    // Static variable: shared by all MovieTicket objects
    static int totalTickets = 0;

    // Constructor to initialize ticket price
    public MovieTicket(double pric) {
        price = pric;
    }

    // Method to book tickets and increase totalTickets
    void increase_totalticket(int amount) {
        totalTickets += amount; // Add booked tickets to total
        System.out.println(amount + " ticket, per ticket price : " + price);
    }

    // Method to display the total number of tickets booked
    void checkTotalTicket() {
        System.out.println("Total ticket : " + totalTickets);
    }
}

public class Movie_ticket {

    public static void main(String[] args) {

        // Create three MovieTicket objects with different prices
        MovieTicket t1 = new MovieTicket(200);
        MovieTicket t2 = new MovieTicket(350);
        MovieTicket t3 = new MovieTicket(350);

        // Book 2 tickets using t1
        t1.increase_totalticket(2);

        // Book 3 tickets using t2
        t2.increase_totalticket(3);

        // Book 6 tickets using t3
        t3.increase_totalticket(6);

        // Display total tickets booked by all objects
        t1.checkTotalTicket();
    }
}