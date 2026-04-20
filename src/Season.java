import java.util.ArrayList;


public class Season {

        private int seasonNumber;
        private ArrayList<Episode> episodes= new ArrayList<>();

        public Season(int seasonNumber, ArrayList<Episode> episodes){
            this.seasonNumber= seasonNumber;
            this.episodes= episodes;

        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public ArrayList<Episode> getEpisodes() {
            return episodes;
        }

        public void setEpisodes(ArrayList<Episode> episodes) {
            this.episodes = episodes;
        }


}
