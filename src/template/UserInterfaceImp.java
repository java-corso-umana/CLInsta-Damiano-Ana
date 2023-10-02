package template;

import model.User;
import utils.Database;

import java.util.Scanner;

import static utils.Database.users;

public class UserInterfaceImp implements UserInterface{
    Database db = new Database();

    boolean isLogged = false;
    Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        String firstMessage ="""
                Benvenuto su CLInsta!
                Accedi o registrati in questo bellissimo social!
                (Inserisci 1 per accedere o 2 per registrarti o E per uscire)
                """;
        boolean status = true;

        do{
            System.out.println(firstMessage);
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "E":
                    status = false;
                default:
                    System.out.println("Comando non riconosciuto");
            }
        }while(status = true);
    }

    @Override
    public void register() {

    }

    @Override
    public void login() throws Exception{
        System.out.print("Inserisci il nickname: ");
        String nickname = sc.nextLine();
        System.out.print("Inserisci la password");
        String password = sc.nextLine();
        for(User user : users){
            if(nickname.equals(user.getNickname()) && password.equals(user.getPassword())){
                System.out.println("Sei loggato");
                isLogged = true;
            }else{
                throw new Exception("Campi errati");
            }
        }
    }

    @Override
    public void showAndCount() {
        UserInterface.super.showAndCount();
    }

    @Override
    public void showFollower() {

    }

    @Override
    public void countFollower() {

    }

    @Override
    public void searchPeople() {

    }

    @Override
    public void showAll() {

    }

    @Override
    public void sendMessage() {

    }

    @Override
    public void logout() {
        System.out.println("Speriamo di rivederti presto");
        isLogged = false;
    }
}
