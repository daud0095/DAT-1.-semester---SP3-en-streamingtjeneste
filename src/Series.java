import java.util.ArrayList;

public class Series extends Media{

    private ArrayList<Season> seasons = new ArrayList<>();  // seasons (flertal)

    public Series(String title, int releaseYear, double rating, ArrayList<Category> categories) {
        super(title, releaseYear, rating);
        this.seasons = seasons;
    }

    @Override
    public void play() {
        System.out.println("Starter serie: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Pauser serie: " + title);
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

}
