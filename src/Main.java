import util.TextUI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        TextUI textUI = new TextUI();

        List<User> users = new ArrayList<>();
        List<Media> media = new ArrayList<>();

        User currentUser = null;

        Menu menu = new Menu(users, media, currentUser, textUI);
        menu.start();
    }
}
