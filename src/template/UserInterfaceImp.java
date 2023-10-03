package template;

import model.User;
import utils.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterfaceImp implements UserInterface{


        private User activeUser;

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
                        this.activeUser = user;
                        runApp();
                } else {
                    throw new Exception("Campi errati");
                }
            }
        }




    public void runApp() throws Exception {
            System.out.println("Benvenuto " + this.activeUser.getName() + '\n');
            boolean status = true;
            do {
                System.out.println("Cosa vorresti fare?");
                String options = """
                        1) Visualizza follow
                        2) Conta follow
                        3) Visualizza e conta seguiti
                        4) Ricerca utenti
                        5) Stampa tutti gli utenti
                        6) Segui utente
                        7) Scrivi ad un utente
                        8) Visualizza i tuoi messaggi
                        9) Login con altro utente
                        10) Visualizza follower
                        11) Conta follower
                        12) Visualizza messaggi ricevuti
                        0) Logout
                        """;
                System.out.println(options);
                String input = sc.nextLine();
                switch (input) {
                    case "1":
                        showFollow();
                        break;
                    case "2":
                        countFollow();
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
                    case "10":
                        showFollower();
                        break;
                    case "11":
                        countFollower();
                        break;
                    case "12":
                        showMessage();
                        break;
                    case "0":
                        status = logout();
                        break;
                    default:
                        break;
                }
            } while (status == true);
            run();
        }

    private void showMessage() {
        for(String str : activeUser.getMessages()){
            System.out.println(str);
        }
    }

    @Override
        public void showFollow() {
            if(!this.activeUser.getFollowing().isEmpty()){
                for(User user : this.activeUser.getFollowing()){
                    System.out.println(user);
                }
            } else {
                System.out.println("Non hai utenti che segui");
            }
            System.out.println("Premi invio per continuare...");
            sc.nextLine();
        }

        @Override
        public void countFollow() {
            System.out.println("In totale segui " + this.activeUser.getFollowing().size()+ " persone");
            System.out.println("Premi invio per continuare...");
            sc.nextLine();
        }

        @Override
        public void searchPeople() {
            showAll();
            System.out.println("Inserisci l'iniziale del nome che vuoi cercare");
            String name = sc.nextLine();
            List<User> tmp = new ArrayList<>();
            for (User user : Database.users) {
                if(user.startsWithIgnoreCase(user.getName(),name)){
                    tmp.add(user);
                }
            }
            if(!tmp.isEmpty()) {
                System.out.println(tmp);
            } else {
                System.out.println("Nessun utente trovato");
            }
            System.out.println("Premi invio per continuare...");
            sc.nextLine();
        }




        @Override
        public void showAll() {
            int i = 1;
            for (User user : Database.users
                    .stream()
                    .filter(user -> !user.getNickname().equals(activeUser.getNickname()))
                    .collect(Collectors.toList())) {
                System.out.println(i + ") " + user.toString());
                i++;
            }
        }



        @Override
        public void sendMessage() {
            showAll();
            System.out.println("Seleziona il nickname dell'utente a cui vuoi mandare il messaggio");
            String nickname = sc.nextLine();
            System.out.print("Inserisci il testo del messaggio: ");
            String message = sc.nextLine();
            boolean trovato = false;
            for (int i = 0; i < Database.users.size(); i++) {
                if (Database.users.get(i).getNickname().equals(nickname)) {
                    Database.users.get(i).getMessages().add(message);
                    trovato = true;
                    break;
                }
            }
            if(!trovato)
                System.out.println("Utente non trovato");
        }

        @Override
        public boolean logout() {
            System.out.println("Speriamo di rivederti presto");
            this.activeUser = null;
            return false;
        }

        @Override
        public void follow() {
            showAll();
            System.out.println("Inserisci il nickname dell'utente da seguire");
            String nicknameFollow = sc.nextLine();
            boolean trovato = false;
            for (int i = 0; i < Database.users.size(); i++) {
                if (Database.users.get(i).getNickname().equals(nicknameFollow)) {
                    this.activeUser.getFollowing().add(Database.users.get(i));
                    trovato = true;
                    break;
                }
            }
            if(!trovato)
                System.out.println("Utente non trovato");
        }

    @Override
    public void logoutAndLogin() throws Exception {
        UserInterface.super.logoutAndLogin();
    }

    @Override
    public void showAndCountFollow(){
        UserInterface.super.showAndCountFollow();
    }

    public void showFollower(){
            Database.users.stream().filter((u) -> u.getFollowing().contains(activeUser)).forEach(System.out::println);
    }
    public void countFollower(){
        System.out.println("Follower: " + Database.users.stream().filter((u) -> u.getFollowing().contains(activeUser)).count());
    }


}

