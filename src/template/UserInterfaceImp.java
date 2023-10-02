package template;

import model.User;
import utils.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceImp implements UserInterface{


        boolean isLogged = false;
        Scanner sc = new Scanner(System.in);

        @Override
        public void run() {
            String firstMessage = """
                    Benvenuto su CLInsta!
                    Accedi o registrati in questo bellissimo social!
                    (Inserisci 1 per accedere o 2 per registrarti o E per uscire)
                    """;

            boolean status = true;

            do {
                System.out.println(firstMessage);
                for (User user : Database.users) {
                    System.out.println(user.getName());
                }
                String input = sc.nextLine();
                switch (input) {
                    case "1":
                        try {
                            login();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case "2":
                        register();
                        break;
                    case "E":
                        status = false;
                    default:
                        System.out.println("Comando non riconosciuto");
                }
            } while (status = true);
        }

        @Override
        public void register() {
            System.out.print("Inserisci il nome: ");
            String name = sc.nextLine();
            System.out.print("Inserisci il cognome: ");
            String surname = sc.nextLine();
            System.out.print("Inserisci un nickname: ");
            String nickname = sc.nextLine();
            System.out.print("Inserisci la tua nuova password: ");
            String password = sc.nextLine();
            User user = new User(name, surname, nickname, password);
            Database.users.add(user);
        }

        @Override
        public void login() throws Exception {
            System.out.print("Inserisci il nickname: ");
            String nickname = sc.nextLine();
            System.out.print("Inserisci la password: ");
            String password = sc.nextLine();
            for (User user : Database.users) {
                if ((nickname.equals(user.getNickname())) && (password.equals(user.getPassword()))) {
                    System.out.println("Sei loggato");
                    isLogged = true;
                    runApp(user);
                } else {
                    throw new Exception("Campi errati");
                }
            }
        }

        @Override
        public void showAndCountFollow() {

        }

        public void runApp(User user) {
            System.out.println("Benvenuto " + user.getName() + '\n');
            boolean status = true;
            do {
                System.out.println("Cosa vorresti fare?");
                String options = """
                        1) Visualizza follower
                        2) Conta follower
                        3) Visualizza e conta seguiti
                        4) Ricerca utenti
                        5) Stampa tutti gli utenti
                        6) Segui utente
                        7) Scrivi ad un utente
                        9) Login con altro utente
                        0) Logout
                        """;
                System.out.println(options);
                String input = sc.nextLine();
                switch (input) {
                    case "1":
                        showFollower();
                        break;
                    case "2":
                        countFollower();
                        break;
                    case "3":
                        showAndCountFollow();
                        break;
                    case "4":
                        searchPeople();
                        break;
                    case "5":
                        showAll();
                        break;
                    case "6":
                        follow();
                        break;
                    case "7":
                        sendMessage();
                        break;
                    case "9":
                        logoutAndLogin();
                        break;
                    case "0":
                        logout();
                        status = false;
                        break;
                }
            } while (status = true);
            run();
        }

        @Override
        public void showFollower() {

        }

        @Override
        public void countFollower() {

        }

        @Override
        public void searchPeople() {
            System.out.println("Inserisci il nome che vuoi cercare");
            String name = sc.nextLine();
            List<User> tmp = new ArrayList<>();
            for (User user : Database.users) {
                if (user.getName().startsWith(name)) {
                    tmp.add(user);
                }
            }
            System.out.println(tmp);
        }

        public static boolean startWithIgnoreCase(String str, String prefix) {
            return str.regionMatches(true, 0, prefix, 0, prefix.length());
        }

        @Override
        public void showAll() {
            for (User user : Database.users) {
                System.out.println(user.toString());
            }
        }

        @Override
        public void sendMessage() {

        }

        @Override
        public void logout() {
            System.out.println("Speriamo di rivederti presto");
            isLogged = false;
        }

        @Override
        public void follow() {

        }

        @Override
        public void logoutAndLogin() {

        }
    }

