import util.TextUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<User> users;
    List<Media> media;
    User currentUser;
    TextUI textUI;


    public Menu(List<User> users, List<Media> media, User currentUser, TextUI textUI) {
        this.users = users;
        this.media = media;
        this.currentUser = currentUser;
        this.textUI = textUI;

    }

    void start() throws FileNotFoundException {
        if (textUI.promptBinary("Har du et login? Y/N")) {
            login();
        } else {
            register();
        }

    }

    void register() throws FileNotFoundException {
        String username = textUI.promptText("Skriv brugernavn:");
        String password = textUI.promptText("Skriv adgangskode:");

        User newUser = new User(username, password);
        users.add(newUser);

        textUI.displayMsg("Bruger oprettet! Velkommen " + username);
        showMenu();
    }

    void login() throws FileNotFoundException {
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

    void showMenu() throws FileNotFoundException {
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

    public void searchMedia() {
        String searchTerm = textUI.promptText("Søg efter title:");
        List<Media> results = new ArrayList<>();

        for (Media m : media) {
            if (m.title.toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(m);
            }
        }

        if (results.isEmpty()) {
            textUI.displayMsg("Ingen resultater fundet.");
        } else {
            textUI.displayMsg("\n=== Søgeresultater ===");
            for (Media m : results) {
                //Media m = results.get(m);
                textUI.displayMsg((1 + 1) + ". " + m);
            }
        }
    }

    public void searchByCategory() throws FileNotFoundException {
        String searchCategory = textUI.promptText("Søg efter kategori:");
        File file = new File("CsvFiles/MovieData.csv");
        Scanner scanner = new Scanner(file);

        List<String> crimeMovies = new ArrayList<>();


        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] parts = line.split(";\\s*"); //

            if (parts.length < 4) continue;

            String name = parts[0];
            String category = parts[2];

            if (category.toLowerCase().contains("crime")) {
                crimeMovies.add(name);
            }
        }

        scanner.close();



        System.out.println("Crime film:");
        for (String movie : crimeMovies) {
            System.out.println(movie);
        }
    }


    void showWatchedMedia(){
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

    void showSavedMedia(){
        List<Media> savedMedia = currentUser.getSavedMedia();
        if (savedMedia.isEmpty()){
            textUI.displayMsg("Ingen resultater fundet.");
        }else{
            for(int i = 0; i < savedMedia.size(); i++){
                textUI.displayMsg((i+1) + ". " + savedMedia.get(i));
            }
        }
        showMenu();


    }
}
