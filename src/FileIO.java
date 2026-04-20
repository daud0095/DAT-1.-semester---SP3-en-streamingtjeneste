import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class FileIO {


    public void saveData(ArrayList<String> list, String path, String header){
        try {

            FileWriter writer = new FileWriter(path);
            writer.write(header+"\n");
            for (String s : list) {
                writer.write(s+"\n");
            }
            writer.close();

        }catch (IOException e) {
            System.out.println("problem: "+ e.getMessage());
        }
    }

    public static ArrayList<String> readData(String path) {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); // skip header "Name, Score"

            while (scan.hasNextLine()) {
                String line = scan.nextLine();   //  "Egon, 1000000"
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke");
        }
        return data;
    }

    public static String[] readData(String path, int length){
        String[] data = new String [length];
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); // skip header "Name, Score"

            for(int i = 0; i < data.length; i++){
                String line = scan.nextLine();
                data[i] = line;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke");
        }
        return data;
    }

    public List<Movie> loadMovies(String path){
        List<Movie> movies = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(path))){
            if(scan.hasNextLine()){
                scan.nextLine(); // skip header
            }

            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] parts = line.split(";");

                String title = parts[0].trim();
                int releaseYear = Integer.parseInt(parts[1].trim());
                List<Category> categories = parseCategories(parts[2].trim());
                double rating = parseRating(parts[3].trim());

                movies.add(new Movie(title, releaseYear, categories, rating));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke: " + e.getMessage());
        }

        return movies;
    }

    public List<Series> loadSeries(String path) {
        List<Series> seriesList = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(path))) {
            if (scan.hasNextLine()) {
                scan.nextLine(); // skip header
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(";");

                String title = parts[0].trim();
                int releaseYear = parseSeriesStartYear(parts[1].trim());
                List<Category> categories = parseCategories(parts[2].trim());
                double rating = parseRating(parts[3].trim());
                List<Season> seasons = parseSeasons(parts[4].trim());

                seriesList.add(new Series(title, releaseYear, categories, rating));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke: " + e.getMessage());
        }

        return seriesList;
    }

    private double parseRating(String text) {
        return Double.parseDouble(text.replace(",", ".").trim());
    }

    private int parseSeriesStartYear(String text) {
        String[] parts = text.split("-");
        return Integer.parseInt(parts[0].trim());
    }

    private List<Category> parseCategories(String text) {
        List<Category> categories = new ArrayList<>();

        String[] parts = text.split(",");

        for (String part : parts) {
            String normalized = part.trim().toUpperCase().replace("-", "_").replace(" ", "_");

            categories.add(Category.valueOf(normalized));
        }

        return categories;
    }

    private List<Season> parseSeasons(String text){
        List<Season> seasons = new ArrayList<>();

        String[] seasonParts = text.split(",");

        for(String seasonPart : seasonParts) {
            String cleaned = seasonPart.trim();
            if (cleaned.isEmpty()){
                continue;
            }

            String[] values = cleaned.split("-");
            int seasonNumber = Integer.parseInt(values[0].trim());
            int episodeCount = Integer.parseInt(values[1].trim());

            Season season = new Season(seasonNumber);
        }

        return seasons;
    }
}
