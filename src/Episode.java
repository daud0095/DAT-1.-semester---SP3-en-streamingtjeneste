public class Episode {

        private int episodeNumber;
        private int duration;

    public Episode (int episodeNumber, int duration) {
        this.episodeNumber = episodeNumber;
        this.duration = duration;
    }

    public void play() {
            System.out.println("Playing episode: " + episodeNumber); // f.eks. ep.1

        }

        public void pause() {
            System.out.println("domain.Episode paused: " + episodeNumber);
        }

        public int getDuration(){
            System.out.println("This ep. duration is: " + duration);
             return duration;

        }

    }


