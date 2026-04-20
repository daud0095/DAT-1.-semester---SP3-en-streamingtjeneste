import java.util.ArrayList;
import java.util.List;

public class Season{

    private int seasonNumber;
    private List<Episode> episodes;

    public Season(int seasonNumber) {
        this.seasonNumber = seasonNumber;
        this.episodes = new ArrayList<>();
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisode(List<Episode> episodes) {
        this.episodes = episodes;
    }



}