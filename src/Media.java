import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class Media {
    protected String title;
    protected int releaseYear;
    protected double rating;
    protected List<Locale.Category> categories;

    public Media(String title, int releaseYear, double rating){
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.categories = new ArrayList<>();
    }

    public void play(){
        System.out.println("Afspiller: " + title + " (Udgivet: " + releaseYear + ", Rating: " + rating + ")" );
        System.out.println("Afspilning starter...");
    }

    public void pause(){
        System.out.println("Afspilning pauseret for: " + title);
    }
}
