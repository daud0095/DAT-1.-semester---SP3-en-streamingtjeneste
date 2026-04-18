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
        if (textUI.promptBinary("Har du et login? Y/N")){
            login();
        }else{
            register();
        }

    }
    void register(){
        String username = textUI.promptText("Skriv brugernavn:");
        String password = textUI.promptText("Skriv adgangskode:");

        User newUser = new User(username, password);
        users.add(newUser);

        textUI.displayMsg("Bruger oprettet! Velkommen " + username);
        showMenu();
    }

    void login(){
        String username = textUI.promptText("Skriv brugernavn");
        String password = textUI.promptText("Skriv adgangskode");

        // finder bruger i listen
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                currentUser = user;
                textUI.displayMsg("Login succesfuldt Velkommen " + username);
                showMenu();
                return;
            }
        }
        textUI.displayMsg("Forkert brugernavn eller adgangskode!");
        start();
    }

    void showMenu(){
        textUI.displayMsg("\n=== Hovedmenu ===");
        textUI.displayMsg("1. Søg efter media");
        textUI.displayMsg("2. Se dine gemte film/serie");
        textUI.displayMsg("3. Se dine sete film/serie");
        textUI.displayMsg("4. Log ud");

        int choice = textUI.promptNumeric("Vælg (1-4):");

        switch (choice){
            case 1: searchMedia(); break;
            case 2: showSavedMedia(); break;
            case 3: showWatchedMedia(); break;
            case 4: start(); break;
            default: textUI.displayMsg("Ugyldigt valg!");
            showMenu();
        }
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
