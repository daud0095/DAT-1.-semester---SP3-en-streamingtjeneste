public class Movie extends Media{
    private int duration;

    public Movie(String title, int releaseYear, double rating) {
        super(title, releaseYear, rating);
    }

public void play() {
    System.out.println("Afspiller film: " + getTitle());
}

public void pause() {
    System.out.println("Film på pause: " + getTitle());
}
}


