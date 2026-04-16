import java.util.ArrayList;
import java.util.List;

public class User {
        private String username;
        private String password;
        private List<Media> watchedMedia;
        private List<Media> saveMedia;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
            this.watchedMedia = new ArrayList<>();
            this.saveMedia = new ArrayList<>();
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

        public List<Media> getSaveMedia(){
            return saveMedia;
        }


    }



