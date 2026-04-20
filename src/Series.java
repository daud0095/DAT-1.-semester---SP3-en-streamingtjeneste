import java.util.List;

public class Series extends Media{

    private String series;
    private List<Season> seasons;

    public Series(String series){
        super("Stranger Things", 2017, 9.0);
        this.series = series;
    }
}
