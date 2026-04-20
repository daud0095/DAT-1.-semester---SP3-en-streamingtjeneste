import java.util.ArrayList;
import java.util.List;

public abstract class Media {

    protected String title;
    protected int releaseYear;
    protected List<Category> categories;
    protected double rating;

    public Media(String title, int releaseYear, List<Category> categories, double rating){
        this.title = title;
        this.releaseYear = releaseYear;
        this.categories = new ArrayList<>(categories);
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - Rating: " + rating;
    }

    public void play(){
        System.out.println("Afspiller: " + title + " (Udgivet: " + releaseYear + ", Rating: " + rating + ")" );
        System.out.println("Afspilning starter...");
    }

    public void pause(){
        System.out.println("Afspilning pauseret for: " + title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Media other = (Media) obj;
        return releaseYear == other.releaseYear && title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, releaseYear);
    }
}
