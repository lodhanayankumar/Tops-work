class Movie {
    String movieName;

    Movie(String movieName) {
        this.movieName = movieName;
    }

    // First overloaded method
    void addReview(int rating) {
        System.out.println("Movie : " + movieName);
        System.out.println("Rating : " + rating + "/10");
    }

    // Second overloaded method
    void addReview(int rating, String comment) {
        System.out.println("Movie : " + movieName);
        System.out.println("Rating : " + rating + "/10");
        System.out.println("Review : " + comment);
    }
}

public class movie_review {
    public static void main(String[] args) {

        Movie movi = new Movie("Bahubali");

        movi.addReview(10);
        System.out.println();

        movi.addReview(10, "Very good movie");
    }
}