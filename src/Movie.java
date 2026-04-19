public class Movie extends Media{
    private int duration;

    public Movie(String title, int releaseYear, double rating){
        super(title, releaseYear, rating);
    }

    public int getDuration(){
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
