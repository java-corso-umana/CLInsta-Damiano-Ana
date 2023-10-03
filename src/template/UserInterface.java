package template;

import java.util.List;

public interface UserInterface {

    void run();
    void register();
    void login() throws Exception;
    void showAndCountFollow();
    void showFollower();
    void countFollower();
    void searchPeople();
    void showAll();
    void sendMessage();
    boolean logout();
    void follow();
    default void logoutAndLogin() throws Exception {
        logout();
        login();
    };


}
