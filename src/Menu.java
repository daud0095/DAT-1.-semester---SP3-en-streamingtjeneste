import util.TextUI;

import java.util.List;

public class Menu {
    List<User>users;
    List<Media>media;
    User currentUser;
    TextUI textUI;


    public Menu(List<User> users, List<Media> media, User currentUser, TextUI textUI) {
        this.users = users;
        this.media = media;
        this.currentUser = currentUser;
        this.textUI = textUI;

    }

    void start(){
        if (textUI.promptBinary("1: Har du et login? Y/N")){
            login();
        }else{
            register();
        }

    }
    void register(){


    }

    void login(){

    }

    void showMenu(){

    }

    void searchMedia(){

    }

    void searchByCategory(){

    }

    void showWatchedMedia(){

    }

    void showSavedMedia(){

    }
}
