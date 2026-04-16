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
            this.watchedMedia = new ArrayList<>();
            this.savedMedia = new ArrayList<>();
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

        public boolean isSaved(Media media){
            return savedMedia.contains(media);
        }

        public boolean isWatched(Media media){
            return watchedMedia.contains(media);
        }


    }



