package template;

public interface UserInterface {

    void run();
    void register();
    void login() throws Exception;
    default void showAndCount(){
        showFollower();
        countFollower();
    }
    void showFollower();
    void countFollower();
    void searchPeople();
    void showAll();
    void sendMessage();
    void logout();


}
