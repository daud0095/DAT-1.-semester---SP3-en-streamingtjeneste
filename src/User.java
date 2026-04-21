import java.util.ArrayList;
import java.util.List;

public class User {
        private String username;
        private String password;
        private List<Media> watchedMedia;
        private List<Media> savedMedia;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
            this.watchedMedia = new ArrayList<>(watchedMedia);
            this.savedMedia = new ArrayList<>(savedMedia);
        }

        public User(String username, String password, List<Media> watchedMedia, List<Media> savedMedia) {
            this.username = username;
            this.password = password;
            this.watchedMedia = new ArrayList<>(watchedMedia);
            this.savedMedia = new ArrayList<>(savedMedia);
        }

        public String getUsername(){
            return username;
        }

        public String getPassword(){
            return password;
        }

        public List<Media> getWatchedMedia(){
            return watchedMedia;
        }

        public List<Media> getSavedMedia(){
            return savedMedia;
        }

        public void addWatchedMedia(Media media){
            if(!watchedMedia.contains(media)){
                watchedMedia.add(media);
            }
        }

        public void removeSavedMedia(Media media){
            savedMedia.remove(media);
        }

        public void addSavedMedia(Media media){
            if(!savedMedia.contains(media)){
                savedMedia.add(media);
            }
        }

        public boolean isSaved(Media media){
            return savedMedia.contains(media);
        }

        public boolean isWatched(Media media){
            return watchedMedia.contains(media);
        }

    }



