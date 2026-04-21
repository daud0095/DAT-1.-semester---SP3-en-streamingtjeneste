import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<User> users;
    List<Media> media;
    User currentUser;
    TextUI textUI;
    FileIO fileIO;


    public Menu(List<User> users, List<Media> media, User currentUser, TextUI textUI, FileIO fileIO) {
        this.users = users;
        this.media = media;
        this.currentUser = currentUser;
        this.textUI = textUI;
        this.fileIO = fileIO;

    }

    public void start() throws FileNotFoundException {
        if (textUI.promptBinary("Har du et login? Y/N")) {
            login();
        } else {
            register();
        }

    }

    public void register() throws FileNotFoundException {
        String username = textUI.promptText("Skriv brugernavn:");
        String password = textUI.promptText("Skriv adgangskode:");

        User newUser = new User(username, password);
        users.add(newUser);
        fileIO.saveUsers("CsvFiles/UserData.csv", users);

        currentUser = newUser;
        textUI.displayMsg("Bruger oprettet! Velkommen " + username);
        showMenu();
    }

    public void login() throws FileNotFoundException {
        String username = textUI.promptText("Skriv brugernavn");
        String password = textUI.promptText("Skriv adgangskode");

        // finder bruger i listen
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                textUI.displayMsg("Login succesfuldt Velkommen " + username);
                showMenu();
                return;
            }
        }
        textUI.displayMsg("Forkert brugernavn eller adgangskode!");
        start();
    }

   public void showMenu() throws FileNotFoundException {
        textUI.displayMsg("\n=== Hovedmenu ===");
        textUI.displayMsg("1. Søg efter media");
        textUI.displayMsg("2. Se dine gemte film/serie");
        textUI.displayMsg("3. Se dine sete film/serie");
        textUI.displayMsg("4. Søg efter kategori");
        textUI.displayMsg("5. Log ud");

        int choice = textUI.promptNumeric("Vælg (1-5):");

        switch (choice) {
            case 1:
                searchMedia();
                break;
            case 2:
                showSavedMedia();
                break;
            case 3:
                showWatchedMedia();
                break;
            case 4:
                searchByCategory();
                break;
            case 5:
                start();
                break;
            default:
                textUI.displayMsg("Ugyldigt valg!");
                showMenu();
        }
    }

    public void searchMedia() throws FileNotFoundException {
        String searchTerm = textUI.promptText("Søg efter title:");
        List<Media> results = new ArrayList<>();

        for (Media m : media) {
            if (m.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(m);
            }
        }

        if (results.isEmpty()) {
            textUI.displayMsg("Ingen resultater fundet.");
        } else {
            textUI.displayMsg("\n=== Søgeresultater ===");
            for (int i = 0; i < results.size(); i++) {
                textUI.displayMsg((i + 1) + ". " + results.get(i));
            }

            textUI.displayMsg("\nHvad vil du gøre?");
            textUI.displayMsg("1. Marker som set");
            textUI.displayMsg("2. Gem film/serie");
            textUI.displayMsg("0. Tilbage");

            int action = textUI.promptNumeric("Vælg (0-2)");

            if (action == 1 || action == 2) {
                int choice = textUI.promptNumeric("vælg nummer for at marker som set");
                if (choice > 0 && choice <= results.size()) {
                Media chosen = results.get(choice - 1);
                if (action == 1) {
                    currentUser.addWatchedMedia(chosen);
                    fileIO.saveUsers("CsvFiles/UserData.csv", users);
                    textUI.displayMsg(chosen.getTitle() + "markeret som set!");
                } else {
                    currentUser.addSavedMedia(chosen);
                    fileIO.saveUsers("CsvFiles/UserData.csv", users);
                    textUI.displayMsg(chosen.getTitle() + "gemt");
                }
                }
            }
        }

        showMenu();
    }

    public void searchByCategory() throws FileNotFoundException  {
        String searchCategory = textUI.promptText("Søg efter kategori:");
        List<Media> results = new ArrayList<>();

        String normalizedSearch = searchCategory.trim().toUpperCase().replace("-", "_").replace(" ", "_");

        for (Media m : media) {
            for (Category category : m.getCategories()) {
                if (category.name().equals(normalizedSearch)) {
                    results.add(m);
                    break;
                }
            }
        }

        if (results.isEmpty()) {
            textUI.displayMsg("Ingen resultater fundet.");
        } else {
            textUI.displayMsg("\n=== Søgeresultater ===");
            for (int i = 0; i < results.size(); i++) {
                textUI.displayMsg((i + 1) + ". " + results.get(i));
            }
        }

        showMenu();
    }


    public void showWatchedMedia() throws FileNotFoundException {
        List<Media> watchedMedia = currentUser.getWatchedMedia();
        if(watchedMedia.isEmpty()){
            textUI.displayMsg("Ingen resultater fundet.");
        }else{
            textUI.displayMsg("\n --- Sete film/Serier --- ");
            for (int i = 0; i < watchedMedia.size(); i++){
                textUI.displayMsg((i+1) + ". " + watchedMedia.get(i));
            }
        }
        showMenu();

    }

    public void showSavedMedia() throws FileNotFoundException {
        List<Media> savedMedia = currentUser.getSavedMedia();
        if (savedMedia.isEmpty()){
            textUI.displayMsg("Ingen resultater fundet.");
        }else{
            textUI.displayMsg("\n --- gemte film/Serier --- ");
            for(int i = 0; i < savedMedia.size(); i++){
                textUI.displayMsg((i+1) + ". " + savedMedia.get(i));
            }
        }
        showMenu();


    }
}
