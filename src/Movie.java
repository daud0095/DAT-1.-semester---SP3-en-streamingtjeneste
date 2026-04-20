import java.util.List;

public class Movie extends Media{

    //private int duration;

    public Movie(String title, int releaseYear, List<Category> categories, double rating) {
        super(title, releaseYear, categories, rating);
    }
}
