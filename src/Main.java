import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TextUI textUI = new TextUI();
        FileIO fileIO = new FileIO();

        List<User> users = new ArrayList<>();
        List<Media> media = new ArrayList<>();

        media.addAll(fileIO.loadMovies("CsvFiles/MovieData.csv"));
        media.addAll(fileIO.loadSeries("CsvFiles/SeriesData.csv"));


        User currentUser = null;

        Menu menu = new Menu(users, media, currentUser, textUI);
        menu.start();
    }
}
