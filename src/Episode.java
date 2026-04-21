public class Episode {

        private int episodeNumber;

    public Episode (int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public void play() {
            System.out.println("Playing episode: " + episodeNumber); // f.eks. ep.1

        }

        public void pause() {
            System.out.println("Episode paused: " + episodeNumber);
        }

        public int getEpisodeNumber() {
            return episodeNumber;
        }
    }


