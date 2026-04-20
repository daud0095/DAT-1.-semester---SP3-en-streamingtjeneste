import java.util.ArrayList;
import java.util.List;

public class Series extends Media{

    private List<Season> seasons;

    public Series(String title, int releaseYear, List<Category> categories, double rating) {
        super(title, releaseYear, categories, rating);
        this.seasons = new ArrayList<>();
    }

    public Series(String title, int releaseYear, List<Category> categories, double rating, List<Season> seasons) {
        super(title, releaseYear, categories, rating);
        this.seasons = new ArrayList<>(seasons);
    }



    @Override
    public void play() {
        System.out.println("Starter serie: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Pauser serie: " + title);
    }

    public List<Season> getSeasons() {
        return seasons;
    }

}
