import java.util.ArrayList;
import java.util.List;

public class Season extends Series {

    private int seasonNumber;
    private List<Episode> episodes;

    public Season(String title, int releaseYear, double rating, ArrayList<Category> categories, int seasonNumber) {
        super(title, releaseYear, rating, categories);
        this.seasonNumber = seasonNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public ArrayList<Episode> getEpisodes() {
        return (ArrayList<Episode>) episodes;
    }

    public void setEpisode(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }



}