import java.util.List;

public class Season extends Series {

    private int seasonNumber;
    private List<Episode> episodes;

    public Season(int seasonNumber) {
        super("5");
        this.seasonNumber = seasonNumber;
    }

    public int getSeasonNumber(){
        return seasonNumber;
    }



}