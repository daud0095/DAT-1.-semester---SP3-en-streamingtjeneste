import java.util.ArrayList;

public class Series extends Media{

    private ArrayList<Season> seasons = new ArrayList<>();  // seasons (flertal)

    public Series(String title, int releaseYear, ArrayList<Category>categories, double rating, String seasonAndEpisodes) {
        super(title, releaseYear, (ArrayList<Category>)categories, rating);
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
